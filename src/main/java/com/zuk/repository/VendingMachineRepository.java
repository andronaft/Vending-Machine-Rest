package com.zuk.repository;

import com.zuk.model.VendingMachine;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface VendingMachineRepository extends JpaRepository<VendingMachine,Long> {
    ArrayList<VendingMachine> findAllByName(String name);
    VendingMachine findByLocation(String location);
}
