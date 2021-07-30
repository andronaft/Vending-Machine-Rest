package com.zuk.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class VendingMachineFieldDto {
    private long machineId;
    private int fieldId;
    private long itemId;
}
