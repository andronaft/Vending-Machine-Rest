package com.zuk.service.impl;


import com.zuk.model.Item;
import com.zuk.model.VendingMachine;
import com.zuk.model.VendingMachineField;
import com.zuk.repository.VendingMachineFieldRepository;
import com.zuk.service.ItemService;
import com.zuk.service.VendingMachineFieldService;
import com.zuk.service.VendingMachineService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@Slf4j
public class VendingMachineFieldServiceImpl implements VendingMachineFieldService {
    private final VendingMachineFieldRepository vmfr;
    private final ItemService itemService;
    private final VendingMachineService vms;

    @Autowired
    public VendingMachineFieldServiceImpl(VendingMachineFieldRepository vmfr, ItemService itemService, VendingMachineService vms) {
        this.vmfr = vmfr;
        this.itemService = itemService;

        this.vms = vms;
    }

    @Override
    public ArrayList<VendingMachineField> getAllFieldByMachineId(Long machineId) {
        return vmfr.findAllByMachineId(machineId);
    }

    @Override
    public Item getItem(Long machineId, int fieldId) {
        VendingMachineField vmf = vmfr.findByMachineIdAndFieldIdInMachine(machineId,fieldId);
        //is there item in spot
        if(vmf == null || vmf.getFirstItemId() == 0){
            return null;
        }

        //operation in vendingMachine when first item is taken, and the second come to first place
        Item item = itemService.getById(vmf.getFirstItemId());

        //is enough money
        VendingMachine vendingMachine = vms.getById(machineId);
        if(vendingMachine.getCurrentDeposit() < item.getPrice()){
            return null;
        }
        vendingMachine.setCurrentDeposit(vendingMachine.getCurrentDeposit() - item.getPrice());
        vendingMachine.setDeposit(vendingMachine.getDeposit() + item.getPrice());
        vms.save(vendingMachine);

        vmf.setFirstItemId(vmf.getSecondItemId());
        vmf.setSecondItemId(0);
        vmfr.save(vmf);

        return item;
    }

    @Override
    public VendingMachineField putNewItem(Long machineId, int fieldId, Long itemId) {
        VendingMachineField vmf = vmfr.findByMachineIdAndFieldIdInMachine(machineId,fieldId);
        if(vmf.getSecondItemId()==0) {
           if(vmf.getFirstItemId()==0){
               vmf.setFirstItemId(itemId);
               return vmfr.save(vmf);
           }
           vmf.setSecondItemId(vmf.getFirstItemId());
           vmf.setFirstItemId(itemId);
           return vmfr.save(vmf);
        }
        //case when it was full
        return null;
    }
}
