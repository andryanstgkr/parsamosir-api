package com.andryanstgkr.parsamosir.api.controller;

import java.util.List;

import com.andryanstgkr.parsamosir.api.base.BaseController;
import com.andryanstgkr.parsamosir.api.model.admin.District;
import com.andryanstgkr.parsamosir.api.service.admin.DistrictService;
import com.andryanstgkr.parsamosir.api.utilities.ResponseHandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("admin/district")
public class DistrictController extends BaseController<District> {

    @Autowired
    public DistrictService districtService;

    @GetMapping("village-count-by-district")
    public ResponseEntity<Object> getVillageCountGroupByDistrict() {

        List<Object[]> objectList = districtService.getVillageCountGroupByDistrict();

        return ResponseHandler.generateResponseList(HttpStatus.OK.getReasonPhrase(), HttpStatus.OK,
                (List<Object[]>) objectList, objectList.size(), 0, 0);
    }
}
