package com.example.Web_Koleso.dto;

import lombok.Data;

@Data
public class TireWarehouseDTO {
    private long tireId;
    private String tireName;
    private String warehouseName;
    private int availableNow;
    private int availableTotal;
    private int providedTotal;
    private int deficitTotal;
    private int surplusTotal;
}
