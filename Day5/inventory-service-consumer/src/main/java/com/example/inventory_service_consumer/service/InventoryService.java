package com.example.inventory_service_consumer.service;

import com.example.inventory_service_consumer.dto.OrderDto;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class InventoryService {

    @KafkaListener(
            topics = "order-events-1",
            groupId = "inventory-group"
    )
    public void consume(OrderDto order) {
        System.out.println("Inventory Service Received Order");
        System.out.println("OrderId: " + order.getOrderId());
        System.out.println("Product: " + order.getProduct());
    }

    }
