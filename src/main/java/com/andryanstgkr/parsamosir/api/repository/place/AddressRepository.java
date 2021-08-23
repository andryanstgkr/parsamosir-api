package com.andryanstgkr.parsamosir.api.repository.place;

import com.andryanstgkr.parsamosir.api.model.Address;
import com.andryanstgkr.parsamosir.api.repository.BaseRepository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends BaseRepository<Address, String> {
    @Modifying
    

    //DDL table modification
    @Query(value = "alter table Address drop column street", nativeQuery = true)
    public void removeStreetColumn();
}
