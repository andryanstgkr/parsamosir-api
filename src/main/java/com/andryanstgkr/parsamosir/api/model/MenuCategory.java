package com.andryanstgkr.parsamosir.api.model;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.andryanstgkr.parsamosir.api.base.BaseEntity;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "menu_category")
@Access(AccessType.FIELD)
public class MenuCategory extends BaseEntity {
    @Column(name = "name", length = 50, nullable = false)
    private String name;
}
