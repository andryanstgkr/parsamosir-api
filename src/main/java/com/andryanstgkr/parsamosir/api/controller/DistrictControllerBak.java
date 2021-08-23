package com.andryanstgkr.parsamosir.api.controller;

import com.andryanstgkr.parsamosir.api.base.BaseController;
import com.andryanstgkr.parsamosir.api.model.admin.District;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("admin/district")
public class DistrictControllerBak extends BaseController<District>{
    Logger logger = LoggerFactory.getLogger(DistrictController.class);
/*
    @Autowired
    private RegencyService regencyService;

    @Autowired
    private DistrictService districtService;

    @GetMapping("all")
    public ResponseEntity<Object> getAllDistcricts() {
        List<District> districtList = new ArrayList<>();
        try {
            districtList = districtService.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseHandler.generateResponseList(e.getMessage(), HttpStatus.BAD_REQUEST, null, 0, 0, 0);
        }
        return ResponseHandler.generateResponseList(HttpStatus.OK.getReasonPhrase(), HttpStatus.OK, districtList, districtList.size(), 0, 0);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Object> getDistrictById(@PathVariable("id") String id) {

        try {
            Optional<District> district = districtService.getDetail(id);
            return ResponseHandler.generateResponse(HttpStatus.OK.getReasonPhrase(), HttpStatus.OK, district.get());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.BAD_REQUEST, null);
        }
    }

    @PostMapping("save")
    public ResponseEntity<Object> saveDistrict(@RequestBody Map<String, String> districtMap) {
        try {
            Regency regency = regencyService.getDetail(districtMap.get("regencyId")).get();
            District district = new District();
            district.setRegency(regency);
            district.setName(districtMap.get("name"));
            district.setCreatedBy(districtMap.get("createdBy"));
            District district1 = (District) districtService.save(district);
            return ResponseHandler.generateResponse(HttpStatus.OK.getReasonPhrase(), HttpStatus.OK, district1);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.BAD_REQUEST, null);
        }

    }

    @PutMapping("update/{id}")
    public ResponseEntity<Object> updateDistrict(@RequestBody Map<String, String> districtMap,
            @PathVariable("id") String id) {
        Optional<District> district = districtService.getDetail(id);
        try {
            if (district.isPresent()) {
                District _district = district.get();
                Regency regency = regencyService.getDetail(districtMap.get("regencyId")).get();
                _district.setRegency(regency);
                _district.setName(districtMap.get("name"));
                _district.setCreatedBy(districtMap.get("createdBy"));
                District district1 = (District) districtService.save(_district);
                return ResponseHandler.generateResponse(HttpStatus.OK.getReasonPhrase(), HttpStatus.OK, district1);
            } else {
                return ResponseHandler.generateResponse(HttpStatus.NOT_FOUND.getReasonPhrase(), HttpStatus.NOT_FOUND,
                        null);
            }

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.BAD_REQUEST, null);
        }

    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Object> deleteDistrict(@PathVariable("id") String id) {
        try {
            Optional<District> district = districtService.getDetail(id);
            districtService.delete(district.get());
            return ResponseHandler.generateResponse(HttpStatus.NO_CONTENT.getReasonPhrase(), HttpStatus.NO_CONTENT, null);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }*/
}
