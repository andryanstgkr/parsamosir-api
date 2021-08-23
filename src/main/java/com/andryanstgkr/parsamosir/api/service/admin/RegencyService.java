package com.andryanstgkr.parsamosir.api.service.admin;

import java.util.Optional;

import com.andryanstgkr.parsamosir.api.model.admin.Regency;
import com.andryanstgkr.parsamosir.api.repository.RegencyRepository;
import com.andryanstgkr.parsamosir.api.service.BaseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegencyService extends BaseService<Regency, String> {

    @Autowired
    private RegencyRepository regencyRepository;

    @Override
    public Regency update(Regency regency, String activity, String id) {
        Regency _regency = new Regency();
        try {
            Optional<Regency> optRegency = regencyRepository.findById(id);
            if (optRegency.isPresent()) {
                _regency = optRegency.get();
                _regency.setIsActive(regency.getIsActive());
                _regency.setIsDeleted(regency.getIsDeleted());
                _regency.setName(regency.getName());
                _regency = regencyRepository.save(_regency);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return _regency;
    }


}
