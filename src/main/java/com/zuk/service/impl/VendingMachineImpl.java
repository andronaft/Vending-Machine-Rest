package com.zuk.service.impl;


import com.zuk.model.VendingMachine;
import com.zuk.repository.VendingMachineRepository;
import com.zuk.service.VendingMachineService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@Slf4j
public class VendingMachineImpl implements VendingMachineService {
    private final VendingMachineRepository vendingMachineRepository;

    public VendingMachineImpl(VendingMachineRepository vendingMachineRepository) {
        this.vendingMachineRepository = vendingMachineRepository;
    }

    @Override
    public VendingMachine getById(Long id) {
        return null;
    }

    @Override
    public ArrayList<VendingMachine> getByName(String name) {
        return null;
    }

    @Override
    public VendingMachine stealMoney(Long vendingMachineId) {
        return null;
    }

    @Override
    public VendingMachine putMoney(int amountOfMoney) {
        return null;
    }

    @Override
    public VendingMachine save(VendingMachine vendingMachine) {
        return null;
    }
}
