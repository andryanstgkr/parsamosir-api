package com.andryanstgkr.parsamosir.api.controller.place;

import com.andryanstgkr.parsamosir.api.base.BaseController;
import com.andryanstgkr.parsamosir.api.model.Accomodation;
import com.andryanstgkr.parsamosir.api.model.Address;
import com.andryanstgkr.parsamosir.api.service.place.AccomodationService;
import com.andryanstgkr.parsamosir.api.utilities.ResponseHandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("accomodation")
public class AccomodationController extends BaseController<Accomodation> {

    @Autowired
    private AccomodationService accomodationService;

    @PostMapping("save-accomodation")
    public ResponseEntity<Object> saveBaseObject(@RequestBody Accomodation accomodation, String regencyId,
            String districtId, String villageId) {
        try {

            Address address = new Address();
            address.setAddress("address");
            accomodation.setAddress(address);

            Accomodation _accomodation = accomodationService.save(accomodation);
            return ResponseHandler.generateResponse(HttpStatus.OK.getReasonPhrase(), HttpStatus.OK, _accomodation);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.BAD_REQUEST, null);
        }

    }

}
