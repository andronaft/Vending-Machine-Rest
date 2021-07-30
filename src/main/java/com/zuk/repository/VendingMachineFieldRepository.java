package com.zuk.repository;

import com.zuk.model.VendingMachineField;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface VendingMachineFieldRepository extends JpaRepository<VendingMachineField,Long> {
    ArrayList<VendingMachineField> findAllByMachineId(Long machineId);
    VendingMachineField findByMachineIdAndFieldIdInMachine(Long machineId,int fieldIdInMachine);
}
