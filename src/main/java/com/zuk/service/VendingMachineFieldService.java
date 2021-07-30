package com.zuk.service;

import com.zuk.model.Item;
import com.zuk.model.VendingMachine;
import com.zuk.model.VendingMachineField;

import java.util.ArrayList;

public interface VendingMachineFieldService {
    ArrayList<VendingMachineField> getAllFieldByMachineId(Long machineId);
    Item getItem(Long machineId, int fieldId);
    VendingMachineField putNewItem(Long machineId, int fieldId, Long itemId);

}
