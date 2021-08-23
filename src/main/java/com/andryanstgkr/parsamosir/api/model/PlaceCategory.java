package com.andryanstgkr.parsamosir.api.model;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.andryanstgkr.parsamosir.api.base.BaseEntity;

import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@Entity
@Access(AccessType.FIELD)
@Table(name = "place_category")
public class PlaceCategory extends BaseEntity {
    @Column(name="name", length = 50, nullable = false)
    private String name;
}
