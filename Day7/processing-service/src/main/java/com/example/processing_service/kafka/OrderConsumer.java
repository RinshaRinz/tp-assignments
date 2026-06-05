package com.example.processing_service.kafka;

import com.example.processing_service.event.OrderEvent;
import com.example.processing_service.service.OrderProcessingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.DltHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.RetryableTopic;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Service;

@Service
public class OrderConsumer {

    @Autowired
    private OrderProcessingService service;

    @RetryableTopic(attempts = "3")
    @KafkaListener(topics = "order-events", groupId = "processing-group")
    public void process(OrderEvent event, Acknowledgment ack) {
        System.out.println("Received order event : " + event);
        service.processOrder(event);
        ack.acknowledge();
    }

    @DltHandler
    public void handleDeadLetter(OrderEvent event) {
        System.out.println("Dead Letter Topic handling for order " + event.getOrderId());
    }
}
