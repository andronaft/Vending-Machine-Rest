package com.zuk.model;


import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(schema = "imperva_db" ,name = "vending_machine_field")
@Data
public class VendingMachineField extends BaseEntity {//sorry about long name( fantasy let down

    @Column(name = "field_id_in_machine")
    private int fieldIdInMachine;

    @Column(name="machine_id")
    private long machineId;

    @Column(name="first_item_id")
    private long firstItemId;

    @Column(name="second_item_id")
    private long secondItemId;

}
