package com.zuk.rest;


import com.zuk.model.Item;
import com.zuk.service.VendingMachineFieldService;
import com.zuk.service.VendingMachineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/vending/")
public class VendingMachineRestControllerV1 {
    private final VendingMachineService vms;
    private final VendingMachineFieldService vmfs;

    @Autowired
    public VendingMachineRestControllerV1(VendingMachineService vms, VendingMachineFieldService vmfs) {
        this.vms = vms;
        this.vmfs = vmfs;
    }

    @GetMapping(value = "putMoney/{id}/{amount}")
    public ResponseEntity<Item> putMoney(@PathVariable(name = "id") long id, @PathVariable(name = "amount") int amount) {
        return new ResponseEntity(vms.putMoney(amount,id), HttpStatus.OK);
    }

    @GetMapping(value = "getChange/{id}")
    public ResponseEntity<Item> getChange(@PathVariable(name = "id") long id) {
        return new ResponseEntity(vms.giveChange(id), HttpStatus.OK);
    }

    @GetMapping(value = "getAllField/{id}")
    public ResponseEntity<Item> getAllField(@PathVariable(name = "id") long id) {
        return new ResponseEntity(vmfs.getAllFieldByMachineId(id), HttpStatus.OK);
    }

    @GetMapping(value = "getItem/{machineId}/{fieldId}")
    public ResponseEntity<Item> getItem(@PathVariable(name = "machineId") long machineId, @PathVariable(name = "fieldId") int fieldId) {
        return new ResponseEntity(vmfs.getItem(machineId,fieldId), HttpStatus.OK);
    }
}
