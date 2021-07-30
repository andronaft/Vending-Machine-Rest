package com.zuk.model;


import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(schema = "imperva_db" ,name = "item")
@Data
public class Item extends BaseEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private int price;
}
