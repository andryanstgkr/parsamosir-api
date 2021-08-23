package com.andryanstgkr.parsamosir.api.model;

import java.util.List;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.andryanstgkr.parsamosir.api.base.BaseEntity;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Access(AccessType.FIELD)
@Table(name = "accomodation")
public class Accomodation extends BaseEntity {

    @Column(name="name", length = 50, nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name= "address_id")
    private Address address;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "accomodation_type_id")
    private PlaceType accomodationType;

    @ElementCollection
    @CollectionTable(name = "picture", joinColumns = @JoinColumn(name = "id"))
    @Column(name = "picture_list")
    private List<Picture> pictureList;
}