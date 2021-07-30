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
public class VendingMachine extends BaseEntity {//sorry about long name( fantasy let down

    @Column(name = "name")
    private String name;

    @Column(name = "location")
    private String location;

    //Amount of money that will be display to user
    @Column(name = "current_deposit")
    private int currentDeposit;

    //Amount of money inside the machine
    @Column(name = "deposit")
    private int deposit;
}
