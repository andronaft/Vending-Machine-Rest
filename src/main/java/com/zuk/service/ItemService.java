package com.zuk.service;

import com.zuk.model.Item;

public interface ItemService {

    Item getById(Long id);
    Item getByName(String name);
    Item delete(Item item);
    Item save(Item item);

}
