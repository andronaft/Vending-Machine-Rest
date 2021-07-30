package com.zuk.service.impl;

import com.zuk.model.Item;
import com.zuk.repository.ItemRepository;
import com.zuk.service.ItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;

    @Autowired
    public ItemServiceImpl(ItemRepository itemRepository1){
        this.itemRepository = itemRepository1;
    }

    @Override
    public Item getById(Long id) {
        return itemRepository.findById(id).get();
    }

    @Override
    public Item getByName(String name) {
        return itemRepository.findByName(name);
    }

    @Override
    public Item delete(Item item) {
        itemRepository.delete(item);
        return null;
    }

    @Override
    public Item save(Item item) {
        return itemRepository.save(item);
    }
}
