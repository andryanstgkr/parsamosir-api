package com.andryanstgkr.parsamosir.api.repository;

import java.util.List;
import java.util.Optional;

import com.andryanstgkr.parsamosir.api.model.admin.District;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DistrictRepository extends BaseRepository<District, String> {

    @Query("select count(v.id), d.name, d.code from Village v inner join District d on v.district.id = d.id group by d.name, d.id order by d.name")
    public List<Object[]> getVillageCountGroupByDistrict();

    @Query("from District d where d.code = ?1")
    public Optional<District> findDistrictByCode(int code);

}
