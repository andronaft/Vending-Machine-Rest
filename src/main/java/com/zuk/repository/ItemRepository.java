package com.zuk.repository;

import com.zuk.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long>{

    Item findByName(String name);
}
