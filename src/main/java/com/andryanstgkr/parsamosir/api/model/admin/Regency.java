package com.andryanstgkr.parsamosir.api.model.admin;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.andryanstgkr.parsamosir.api.base.BaseEntity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@Entity
@ToString
@Table(name = "regency")
@Access(value = AccessType.FIELD)
public class Regency extends BaseEntity {

    @Column(name = "name", length = 40, nullable = false)
    private String name;
}
