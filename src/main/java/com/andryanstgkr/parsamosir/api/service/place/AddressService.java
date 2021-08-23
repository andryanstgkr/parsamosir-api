package com.andryanstgkr.parsamosir.api.service.place;

import javax.transaction.Transactional;

import com.andryanstgkr.parsamosir.api.model.Address;
import com.andryanstgkr.parsamosir.api.repository.place.AddressRepository;
import com.andryanstgkr.parsamosir.api.service.BaseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService extends BaseService<Address, String> {

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public Address update(Address t, String activity, String id) {
        return null;
    }

    @Transactional
    public void removeStreetColumn(){
        addressRepository.removeStreetColumn();
    }

}
