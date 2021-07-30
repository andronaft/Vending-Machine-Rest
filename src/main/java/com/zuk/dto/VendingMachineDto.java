package com.zuk.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.zuk.model.VendingMachine;
import com.zuk.model.enums.Status;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class VendingMachineDto {
    private String name;
    private String location;

    public VendingMachine toVendingMachine(){
       VendingMachine vendingMachine = new VendingMachine();
       vendingMachine.setName(name);
       vendingMachine.setDeposit(0);
       vendingMachine.setCurrentDeposit(0);
       vendingMachine.setLocation(location);
       vendingMachine.setStatus(Status.ACTIVE);
       return vendingMachine;
    }
}
