package com.andryanstgkr.parsamosir.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.andryanstgkr.parsamosir.api.base.BaseEntity;

import org.springframework.data.annotation.AccessType;
import org.springframework.data.annotation.AccessType.Type;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@AccessType(Type.FIELD)
@Table(name = "address")
public class Address extends BaseEntity {

    @Column(name = "address", length = 500)
    private String address;

    @Column(name = "zip_code", length = 5)
    private String zipCode;

    @Column(name = "latitude", length = 100)
    private String latitude;

    @Column(name = "longitude", length = 100)
    private String longitude;

    @Column(name = "place_id", length = 100)
    private String placeId;

}
