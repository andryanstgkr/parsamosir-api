package com.andryanstgkr.parsamosir.api.controller;

import java.util.ArrayList;
import java.util.List;

import com.andryanstgkr.parsamosir.api.base.BaseController;
import com.andryanstgkr.parsamosir.api.model.Place;
import com.andryanstgkr.parsamosir.api.service.PlaceService;
import com.andryanstgkr.parsamosir.api.utilities.ResponseHandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("place")
public class PlaceController extends BaseController<Place> {

   @Autowired
   private PlaceService placeService;

   @GetMapping("villageName={villageName}")
   public ResponseEntity<Object> getAllPlacesByVillageName(@PathVariable String villageName) {
      List<Place> baseList = new ArrayList<>();
      try {
         baseList = placeService.getPlaceByVillageName(villageName);
      } catch (Exception e) {
         e.printStackTrace();
         return ResponseHandler.generateResponseList(e.getMessage(), HttpStatus.BAD_REQUEST, null, 0, 0, 0);
      }
      return ResponseHandler.generateResponseList(HttpStatus.OK.getReasonPhrase(), HttpStatus.OK,
            (List<Place>) baseList, baseList.size(), 0, 0);
   }
}
