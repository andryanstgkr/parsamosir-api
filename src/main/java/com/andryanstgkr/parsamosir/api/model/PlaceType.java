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

@Setter
@Getter
@Entity
@Access(AccessType.FIELD)
@Table(name = "place_type")
public class PlaceType extends BaseEntity {
    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "place_category_id")
    private PlaceCategory placeCategory;

    @Column(name = "description", length = 250, nullable = false)
    private String description;
}
