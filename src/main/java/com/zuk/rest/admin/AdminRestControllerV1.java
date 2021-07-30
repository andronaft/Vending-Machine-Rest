package com.zuk.rest.admin;

import com.zuk.dto.ItemDto;
import com.zuk.dto.VendingMachineDto;
import com.zuk.dto.VendingMachineFieldDto;
import com.zuk.model.Item;
import com.zuk.service.ItemService;
import com.zuk.service.UserService;
import com.zuk.service.VendingMachineFieldService;
import com.zuk.service.VendingMachineService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/api/v1/admin/")
public class AdminRestControllerV1 {

    private final UserService userService;
    private final ItemService itemService;
    private final VendingMachineService vendingMachineService;
    private final VendingMachineFieldService vmfs;

    @Autowired
    public AdminRestControllerV1(UserService userService, ItemService itemService, VendingMachineService vendingMachineService, VendingMachineFieldService vmfs) {
        this.userService = userService;
        this.itemService = itemService;
        this.vendingMachineService = vendingMachineService;
        this.vmfs = vmfs;
    }

    @GetMapping(value = "item/delete/{id}")
    public ResponseEntity deleteById(@PathVariable(name = "id") long id) {

        Item item = itemService.getById(id);
        itemService.delete(item);
        return new ResponseEntity("Deleted", HttpStatus.OK);
    }

    @PostMapping("item/create")
    public ResponseEntity itemCreate(@RequestBody ItemDto itemDto) {
        return new ResponseEntity(itemService.save(itemDto.toItem()), HttpStatus.OK);
    }

    @PostMapping("vendingMachine/create")
    public ResponseEntity vendingMachineCreate(@RequestBody VendingMachineDto vendingMachineDto) {
        return new ResponseEntity(vendingMachineService.save(vendingMachineDto.toVendingMachine()), HttpStatus.OK);
    }

    @GetMapping(value = "vendingMachine/s†ealMoney/{id}")
    public ResponseEntity vendingMachineStealMoney(@PathVariable(name = "id") long id) {

        return new ResponseEntity(vendingMachineService.stealMoney(id), HttpStatus.OK);
    }

    @PostMapping("vendingMachineField/putItem")
    public ResponseEntity putItemInField(@RequestBody VendingMachineFieldDto vmfd){
        return new ResponseEntity(vmfs.putNewItem(vmfd.getMachineId(),vmfd.getFieldId(),vmfd.getItemId()),HttpStatus.OK);
    }

}