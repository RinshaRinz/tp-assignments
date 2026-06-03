package com.example.inventory_service_consumer.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {

    private Integer orderId;
    private String product;
    private Double amount;
}

