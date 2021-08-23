package com.andryanstgkr.parsamosir.api.repository;

import java.util.List;

import com.andryanstgkr.parsamosir.api.model.admin.District;
import com.andryanstgkr.parsamosir.api.model.admin.Village;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface VillageRepository extends BaseRepository<Village, String> {

    // use alias for pagination
    @Query("from Village v where v.district = ?1")
    public Page<Village> findByDistrict(Pageable pageable, District district);

    // @Query("from Village v inner join District d on v.district.id = d.id where
    // d.code=?1 order by v.name asc")
    @Query("from Village v where v.district.code = ?1 order by  v.type desc, v.name asc")
    public List<Village> getVillagesByDistrictCode(int code);

    @Query("from Village v where v.district.name = ?1")
    public List<Village> getVillagesByDistrictName(String name);

    @Query("from Village v where v.district.code = ?1")
    public List<Village> getVillagesGroupByDistrict(int code);

}
