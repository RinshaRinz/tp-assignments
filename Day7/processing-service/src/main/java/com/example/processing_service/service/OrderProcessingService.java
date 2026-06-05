package com.example.processing_service.service;

import com.example.processing_service.event.OrderEvent;
import com.example.processing_service.event.OrderStatusEvent;
import com.example.processing_service.kafka.OrderProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderProcessingService {

    @Autowired
    private OrderProducer orderProducer;

    public void processOrder(OrderEvent event) {

        if ("FAIL".equalsIgnoreCase(event.getProductName())) {
            throw new IllegalStateException("Failed to proceed further");
        }

        String status;

        if (event.getQuantity() <= 5) {
            status = "APPROVED";
        } else {
            status = "REJECTED";
        }

        OrderStatusEvent response =
                new OrderStatusEvent(event.getOrderId(), status );
        orderProducer.produceOrderEvent(response);
    }
}
