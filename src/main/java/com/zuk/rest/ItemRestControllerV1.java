package com.zuk.rest;


import com.zuk.dto.auth.AuthenticationRequestDto;
import com.zuk.model.Item;
import com.zuk.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/item/")
public class ItemRestControllerV1 {

    private final ItemService itemService;

    @Autowired
    public ItemRestControllerV1(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<Item> getItemById(@PathVariable(name = "id") long id) {

        Item result = itemService.getById(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping(value = "byName/{name}")
    public ResponseEntity<Item> getItemById(@PathVariable(name = "name") String name) {

        Item result = itemService.getByName(name);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }


}
