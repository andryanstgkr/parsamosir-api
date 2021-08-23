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
@Table(name = "restaurant")
@Access(AccessType.FIELD)
public class Restaurant extends BaseEntity {
    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @Column(name = "owner", length = 50, nullable = false)
    private String owner;

    @Column(name = "phone_number", length = 13, nullable = false)
    private String phoneNumber;
    @Column(name = "email", length = 50, nullable = false)
    private String email;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "address_id")
    private Address address;
}
