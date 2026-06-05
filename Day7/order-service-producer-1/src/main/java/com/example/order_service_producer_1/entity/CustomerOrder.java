package com.example.order_service_producer_1.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "orders")
public class CustomerOrder {

    @Id
    @GeneratedValue
    private Long orderId;

    private Long userId;
    private String productName;
    private int quantity;
    private String status;
}

