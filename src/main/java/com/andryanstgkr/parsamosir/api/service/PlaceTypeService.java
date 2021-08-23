package com.andryanstgkr.parsamosir.api.service;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

import com.andryanstgkr.parsamosir.api.constant.ActivityConstant;
import com.andryanstgkr.parsamosir.api.constant.StatusConstant;
import com.andryanstgkr.parsamosir.api.model.ActivityLog;
import com.andryanstgkr.parsamosir.api.model.PlaceType;
import com.andryanstgkr.parsamosir.api.repository.PlaceTypeRepository;
import com.andryanstgkr.parsamosir.api.utilities.CommonUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlaceTypeService extends BaseService<PlaceType, String>{

    @Autowired
    private PlaceTypeRepository placeTypeRepository;

    @Override
    public PlaceType update(PlaceType placeType, String activity, String id) {

        String errorMessage = "";
        String status = StatusConstant.SUCCESSFUL;
        PlaceType _placeType = new PlaceType();
        PlaceType placeTypeToBeLogged = new PlaceType();
        try {
            Optional<PlaceType> optPlaceType = placeTypeRepository.findById(id);

            if (optPlaceType.isPresent()) {
                _placeType = optPlaceType.get();
                placeTypeToBeLogged = optPlaceType.get();
                if (activity.equals(ActivityConstant.DEACTIVATE)) {
                    _placeType.setIsActive(false);
                } else if (activity.equals(ActivityConstant.DELETE)) {
                    _placeType.setIsDeleted(true);
                } else {
                    _placeType.setDescription(placeType.getDescription());
                    _placeType.setIsActive(placeType.getIsActive());
                    _placeType.setIsDeleted(placeType.getIsDeleted());
                    _placeType.setName(placeType.getName());
                    _placeType.setPlaceCategory(placeType.getPlaceCategory());
                }
            }
        } catch (Exception e) {
            logger.error("Error while update placeType: ", e);
            status = StatusConstant.ERROR;
            errorMessage = CommonUtil.getErrorStackTrace(e);
        } finally {
            ActivityLog activityLog = new ActivityLog(id, id, UUID.randomUUID().toString(), "Andryan", activity,
                    "placeType", "placeType", "placeType", LocalDate.now(), true, placeType.toString(),
                    placeTypeToBeLogged.toString(), status, errorMessage);

            logger.debug(activityLog.toString());
            try {
                if (null != _placeType) {
                    _placeType = placeTypeRepository.save(_placeType);
                }
                
              //  placeTypeRepository.save(activityLog);
            } catch (Exception e) {
                logger.error("Error while insert ActivityLog: ", e);
            }
        }

        return _placeType;
    }
}
