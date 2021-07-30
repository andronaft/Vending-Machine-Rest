package com.zuk.rest.admin;

import com.zuk.dto.ItemDto;
import com.zuk.dto.auth.AuthenticationRequestDto;
import com.zuk.model.Item;
import com.zuk.service.ItemService;
import com.zuk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/api/v1/admin/")
public class AdminRestControllerV1 {

    private final UserService userService;
    private final ItemService itemService;

    @Autowired
    public AdminRestControllerV1(UserService userService, ItemService itemService) {
        this.userService = userService;
        this.itemService = itemService;
    }

    @GetMapping(value = "item/delete/{id}")
    public ResponseEntity deleteById(@PathVariable(name = "id") long id) {

        Item item = itemService.getById(id);
        itemService.delete(item);
        return new ResponseEntity<>("Deleted", HttpStatus.OK);
    }

    @PostMapping("item/create")
    public ResponseEntity login(@RequestBody ItemDto itemDto) {
        return new ResponseEntity<>(itemService.save(itemDto.toItem()), HttpStatus.OK);
    }



}