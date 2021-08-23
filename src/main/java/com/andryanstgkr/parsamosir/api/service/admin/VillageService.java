package com.andryanstgkr.parsamosir.api.service.admin;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.andryanstgkr.parsamosir.api.constant.ActivityConstant;
import com.andryanstgkr.parsamosir.api.constant.StatusConstant;
import com.andryanstgkr.parsamosir.api.model.ActivityLog;
import com.andryanstgkr.parsamosir.api.model.admin.District;
import com.andryanstgkr.parsamosir.api.model.admin.Village;
import com.andryanstgkr.parsamosir.api.predicate.KelurahanPredicate;
import com.andryanstgkr.parsamosir.api.repository.ActivityLogRepository;
import com.andryanstgkr.parsamosir.api.repository.DistrictRepository;
import com.andryanstgkr.parsamosir.api.repository.VillageRepository;
import com.andryanstgkr.parsamosir.api.service.BaseService;
import com.andryanstgkr.parsamosir.api.utilities.CommonUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class VillageService extends BaseService<Village, String> {

    Logger logger = LoggerFactory.getLogger(VillageService.class);

    @Autowired
    private VillageRepository villageRepository;

    @Autowired
    private DistrictRepository districtRepository;

    @Autowired
    private ActivityLogRepository activityLogRepository;

    @Override
    public Village update(Village village, String activity, String id) {

        String errorMessage = "";
        String status = StatusConstant.SUCCESSFUL;
        Village _village = new Village();
        Village villageToBeLogged = new Village();
        try {
            Optional<Village> optVillage = villageRepository.findById(id);

            if (optVillage.isPresent()) {
                _village = optVillage.get();
                villageToBeLogged = optVillage.get();
                if (activity.equals(ActivityConstant.DEACTIVATE)) {
                    _village.setIsActive(false);
                } else if (activity.equals(ActivityConstant.DELETE)) {
                    _village.setIsDeleted(true);
                } else {
                    _village.setDistrict(village.getDistrict());
                    _village.setIsActive(village.getIsActive());
                    _village.setIsDeleted(village.getIsDeleted());
                    _village.setName(village.getName());
                }
            }
        } catch (Exception e) {
            logger.error("Error while update Village: ", e);
            status = StatusConstant.ERROR;
            errorMessage = CommonUtil.getErrorStackTrace(e);
        } finally {

            // TODO to save before and after value match
            ActivityLog activityLog = new ActivityLog(id, id, UUID.randomUUID().toString(), "Andryan", activity,
                    "Village", "Village", "VILLAGE", LocalDate.now(), true, village.toString(),
                    villageToBeLogged.toString(), status, errorMessage);

            logger.debug(activityLog.toString());
            try {
                if (null != _village) {
                    _village = villageRepository.save(_village);
                }

                activityLogRepository.save(activityLog);
            } catch (Exception e) {
                logger.error("Error while insert ActivityLog: ", e);
            }
        }

        return _village;
    }

    /**
     * 
     * @param districtId
     * @param pageNo
     * @param pageSize
     * @param sort
     * @return
     */
    public List<Village> getByDistrictWithPagination(String districtId, int pageNo, int pageSize, Sort sort) {
        Optional<District> district = districtRepository.findById(districtId);

        List<Village> villageList = new ArrayList<>();
        if (district.isPresent()) {

            Pageable paging = PageRequest.of(pageNo, pageSize, sort);

            Page<Village> pagedResult = villageRepository.findByDistrict(paging, district.get());

            if (pagedResult.hasContent()) {
                villageList = pagedResult.getContent();
            } else {
                return new ArrayList<Village>();
            }
        }

        return villageList;
    }

    public List<Village> getVillageByDistrict(int code) {
        Optional<District> district = districtRepository.findDistrictByCode(code);

        List<Village> villageList = new ArrayList<>();
        if (district.isPresent()) {
            villageList = villageRepository.getVillagesByDistrictCode(code);
        }

        return villageList;
    }

    public List<Village> getVillagesGroupByDistrict(int code) {

        List<Village> villageList = new ArrayList<>();

        villageList = villageRepository.getVillagesByDistrictCode(code);

        return villageList;
    }

    public List<Village> getAllKelurahan(KelurahanPredicate p) {
        List<Village> villageList = new ArrayList<>();
        Iterator<Village> villageIterator = villageRepository.findAll().iterator();
        villageIterator.forEachRemaining(villageList::add);
        List<Village> kelurahanList = new ArrayList<>();
        for (Village village : villageList) {
            if (p.test(village)) {
                kelurahanList.add(village);
            }
        }
        return kelurahanList;
    }
}