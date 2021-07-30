package com.zuk.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.zuk.model.Item;
import com.zuk.model.enums.Status;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ItemDto {

    private int price;
    private String name;

    public Item toItem(){
        Item item = new Item();
        item.setName(name);
        item.setPrice(price);
        item.setStatus(Status.ACTIVE);
        return item;
    }

}
