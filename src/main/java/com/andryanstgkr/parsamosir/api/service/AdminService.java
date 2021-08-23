package com.andryanstgkr.parsamosir.api.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.andryanstgkr.parsamosir.api.model.admin.District;
import com.andryanstgkr.parsamosir.api.model.admin.Regency;
import com.andryanstgkr.parsamosir.api.repository.DistrictRepository;
import com.andryanstgkr.parsamosir.api.repository.RegencyRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private RegencyRepository regencyRepository;

    @Autowired
    private DistrictRepository districtRepository;

    public List<Regency> getAllRegencies() {
        List<Regency> regencies = new ArrayList<>();
        Iterator<Regency> iterRegencies = regencyRepository.findAll().iterator();
        iterRegencies.forEachRemaining(regencies::add);
        iterRegencies.remove();
        return regencies;
    }

    public List<District> getAllDistricts() {
        List<District> districts = new ArrayList<District>();
        Iterator<District> iteratorDistrict = districtRepository.findAll().iterator();
        iteratorDistrict.forEachRemaining(districts::add);
        return districts;
    }
}
