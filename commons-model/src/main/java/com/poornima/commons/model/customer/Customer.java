package com.poornima.commons.model.customer;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
@Data
public class Customer {

    @Id
    private String id;
    private String name;
    private String address;
    private String contact;
}
