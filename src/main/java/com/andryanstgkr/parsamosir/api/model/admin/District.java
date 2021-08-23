package com.andryanstgkr.parsamosir.api.model.admin;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.andryanstgkr.parsamosir.api.base.BaseEntity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@ToString
@Table(name = "district")
@Access(value = AccessType.FIELD)
public class District extends BaseEntity {

    @Column(name = "name", length = 50, nullable = false)
    @ToString.Include
    private String name;

    @Column(name = "code")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int code;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "regency_id")
    private Regency regency;

}
