package com.andryanstgkr.parsamosir.api.model;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.andryanstgkr.parsamosir.api.base.BaseEntity;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Access(AccessType.FIELD)
@Table(name = "place")
public class Place extends BaseEntity {

    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @Column(name = "owner", length = 50, nullable = false)
    private String owner;

    @Column(name = "phone_number", length = 13, nullable = false)
    private String phoneNumber;

    @Column(name = "email", length = 50, nullable = false)
    private String email;

    @Column(name = "description", length = 500, nullable = false)
    private String description;

    @Column(name = "related_link", length = 250)
    private String relatedLink;

    @Column(name = "village_name", length = 50, nullable = false)
    private String villageName;

    @Column(name = "street", length = 100, nullable = false)
    private String street;

    @Column(name = "district_name", length = 100, nullable = false)
    private String districtName;

    @Column(name = "regency_name", length = 100, nullable = false)
    private String regencyName;

    @Column(name = "postal_code", length = 5, nullable = false)
    private String postalCode;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "place_type_id")
    private PlaceType placeType;

}
