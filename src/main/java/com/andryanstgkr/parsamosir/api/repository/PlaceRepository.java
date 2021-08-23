package com.andryanstgkr.parsamosir.api.repository;

import java.util.List;

import com.andryanstgkr.parsamosir.api.model.Place;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaceRepository extends BaseRepository<Place, String>{
   
   @Query("from Place p where p.villageName like ?1%")
   public List<Place> getPlaceByVillageName(String villageName);
}
