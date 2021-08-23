package com.andryanstgkr.parsamosir.api.service.admin;

import java.util.List;
import java.util.Optional;

import com.andryanstgkr.parsamosir.api.model.admin.District;
import com.andryanstgkr.parsamosir.api.repository.DistrictRepository;
import com.andryanstgkr.parsamosir.api.service.BaseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DistrictService extends BaseService<District, String> {

    @Autowired
    private DistrictRepository districtRepository;

    @Override
    public District update(District district, String activity, String id) {
        District _district = new District();
        try {
            Optional<District> optDistrict = districtRepository.findById(id);
            if (optDistrict.isPresent()) {
                _district = optDistrict.get();
                _district.setName(district.getName());
                _district.setIsActive(district.getIsActive());
                _district.setIsDeleted(district.getIsDeleted());
                _district.setRegency(district.getRegency());
                _district = districtRepository.save(_district);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return _district;
    }

    public List<Object[]> getVillageCountGroupByDistrict(){
        List<Object[]> objectList = districtRepository.getVillageCountGroupByDistrict();

        return objectList;
    }
}
