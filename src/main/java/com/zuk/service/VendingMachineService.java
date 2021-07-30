package com.zuk.service;

import com.zuk.model.VendingMachine;

import java.util.ArrayList;

public interface VendingMachineService {

    VendingMachine getById(Long id);
    ArrayList<VendingMachine> getByName(String name);

    VendingMachine stealMoney(Long vendingMachineId);
    VendingMachine putMoney(int amountOfMoney);

    VendingMachine save(VendingMachine vendingMachine);
}
