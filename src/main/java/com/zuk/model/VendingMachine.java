package com.zuk.model;


import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(schema = "imperva_db" ,name = "vending_machine")
@Data
public class VendingMachine extends BaseEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "location")
    private String location;

    @Column(name = "current_deposit")
    private int currentDeposit;

    @Column(name = "deposit")
    private int deposit;
}
