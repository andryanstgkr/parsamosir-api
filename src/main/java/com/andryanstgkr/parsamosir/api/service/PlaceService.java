package com.andryanstgkr.parsamosir.api.service;

import java.util.List;

import com.andryanstgkr.parsamosir.api.model.Place;
import com.andryanstgkr.parsamosir.api.repository.PlaceRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlaceService extends BaseService<Place, String>{

    @Autowired
    private PlaceRepository placeRepository;

    @Override
    public Place update(Place t, String activity, String id) {
        return null;
    }
    
    public List<Place> getPlaceByVillageName(String villageName){
        return placeRepository.getPlaceByVillageName(villageName);
    }
}
