package com.andryanstgkr.parsamosir.api.controller;

import java.util.ArrayList;
import java.util.List;

import com.andryanstgkr.parsamosir.api.base.BaseController;
import com.andryanstgkr.parsamosir.api.model.admin.Village;
import com.andryanstgkr.parsamosir.api.service.admin.VillageService;
import com.andryanstgkr.parsamosir.api.utilities.ResponseHandler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("admin/village")
public class VillageController extends BaseController<Village> {

    Logger logger = LoggerFactory.getLogger(VillageController.class);

    @Autowired
    private VillageService villageService;

    @GetMapping("page/districtId={districtId}&pageNo={pageNo}&pageSize={pageSize}&SortBy={sortBy}&SortType={sortType}")
    public ResponseEntity<Object> getByDistrictWithPagination(@PathVariable String districtId, @PathVariable int pageNo,
            @PathVariable int pageSize, @PathVariable String sortBy, @PathVariable String sortType) {
        List<Village> villageList = new ArrayList<>();
        try {
            int retrievePageNo = pageNo - 1;

            villageList = villageService.getByDistrictWithPagination(districtId, retrievePageNo,
                    pageSize == 0 ? 10 : pageSize,
                    Sort.by(sortType.equals("ASC") ? Sort.Direction.ASC : Sort.Direction.DESC, sortBy));
            logger.error("Village List: " + villageList);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseHandler.generateResponseList(e.getMessage(), HttpStatus.BAD_REQUEST, null, 0, 0, 0);
        }
        return ResponseHandler.generateResponseList(HttpStatus.OK.getReasonPhrase(), HttpStatus.OK,
                (List<Village>) villageList, villageList.size(), pageNo, 0);
    }

    @GetMapping("district/{code}")
    public ResponseEntity<Object> getByDistrict(@PathVariable int code) {
        List<Village> villageList = new ArrayList<>();
        try {

            villageList = villageService.getVillageByDistrict(code);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseHandler.generateResponseList(e.getMessage(), HttpStatus.BAD_REQUEST, null, 0, 0, 0);
        }
        return ResponseHandler.generateResponseList(HttpStatus.OK.getReasonPhrase(), HttpStatus.OK,
                (List<Village>) villageList, villageList.size(), 1, 0);
    }

    @GetMapping("districts/{code}")
    public ResponseEntity<Object> getVillagesByDistrict(@PathVariable int code) {
        List<Village> villageList = new ArrayList<>();

        try {
            logger.info("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@code: " + code);
            System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@code: " + code);
            villageList = villageService.getVillagesGroupByDistrict(code);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseHandler.generateResponseList(e.getMessage(), HttpStatus.BAD_REQUEST, null, 0, 0, 0);
        }
        return ResponseHandler.generateResponseList(HttpStatus.OK.getReasonPhrase(), HttpStatus.OK,
                (List<Village>) villageList, villageList.size(), 1, 0);

    }
}
