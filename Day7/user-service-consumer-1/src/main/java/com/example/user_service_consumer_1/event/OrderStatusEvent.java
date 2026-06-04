package com.example.user_service_consumer_1.event;


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
