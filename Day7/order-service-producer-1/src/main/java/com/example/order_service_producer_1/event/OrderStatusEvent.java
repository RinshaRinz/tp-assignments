package com.example.order_service_producer_1.event;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderStatusEvent {
    private Long orderId;
    private String status;
}
