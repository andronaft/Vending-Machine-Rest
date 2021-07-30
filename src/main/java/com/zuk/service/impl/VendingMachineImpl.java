package com.zuk.service.impl;


import com.zuk.model.VendingMachine;
import com.zuk.repository.VendingMachineRepository;
import com.zuk.service.VendingMachineService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@Slf4j
public class VendingMachineImpl implements VendingMachineService {
    private final VendingMachineRepository vendingMachineRepository;
    private int amountOfMoney;
    private Long vendingMachineId;

    @Autowired
    public VendingMachineImpl(VendingMachineRepository vendingMachineRepository) {
        this.vendingMachineRepository = vendingMachineRepository;
    }

    @Override
    public VendingMachine getById(Long id) {
        return vendingMachineRepository.findById(id).get();
    }

    @Override
    public ArrayList<VendingMachine> getByName(String name) {
        return vendingMachineRepository.findAllByName(name);
    }

    @Override
    public VendingMachine stealMoney(Long vendingMachineId) {// I mean that admin will take money from Machine
        VendingMachine vendingMachine = getById(vendingMachineId);
        vendingMachine.setCurrentDeposit(0);
        vendingMachine.setDeposit(0);
        return vendingMachineRepository.save(vendingMachine);
    }

    @Override
    public VendingMachine putMoney(int amountOfMoney, Long vendingMachineId) {
        VendingMachine vendingMachine = getById(vendingMachineId);
        vendingMachine.setCurrentDeposit(vendingMachine.getCurrentDeposit() + amountOfMoney);
        return vendingMachineRepository.save(vendingMachine);
    }

    @Override
    public VendingMachine giveChange(Long vendingMachineId) {
        VendingMachine vendingMachine = getById(vendingMachineId);
        vendingMachine.setCurrentDeposit(0);
        return vendingMachineRepository.save(vendingMachine);
    }

    @Override
    public VendingMachine save(VendingMachine vendingMachine) {
        return vendingMachineRepository.save(vendingMachine);
    }
}
