package com.andryanstgkr.parsamosir.api.model;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.andryanstgkr.parsamosir.api.base.BaseEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "roles")
@Access(value = AccessType.FIELD)
public class Role extends BaseEntity{
    
    @Column(name = "no", length = 2, nullable = false)
    private int no;

    @Column(name = "name", length = 100, nullable = false)
    private String name;

    @Column(name = "description", length = 100, nullable = false)
    private String description;
}
