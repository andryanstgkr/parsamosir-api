package com.andryanstgkr.parsamosir.api.model;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.andryanstgkr.parsamosir.api.base.BaseEntity;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "menu")
@Access(AccessType.FIELD)
public class Menu extends BaseEntity{
    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @Column(name = "price", nullable = false)
    private Double price;

    @Column(name = "is_halal")
    private boolean isHalal;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "menu_category_id")
    private MenuCategory menuCategory;

    @Column(name = "object_id", length = 50, nullable = false)
    private String objectId;

}
