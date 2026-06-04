package com.example.processing_service.configs;

import com.example.processing_service.event.OrderEvent;
import com.example.processing_service.event.OrderStatusEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.RetryableTopic;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

@Component
public class OrderProcessor {


    @Autowired
    private KafkaTemplate<String, OrderStatusEvent> kafkaTemplate;

    @KafkaListener(topics = "order-events", groupId = "processing-group")
    public void process(OrderEvent event, Acknowledgment ack) {

        String status;

        if (event.getQuantity() <= 5) {
            status = "APPROVED";
        } else {
            status = "REJECTED";
        }

        OrderStatusEvent response =
                new OrderStatusEvent(event.getOrderId(), status);
        kafkaTemplate.send("order-status-events", response);
        ack.acknowledge();

    }


    @RetryableTopic(attempts = "3")
    @KafkaListener(topics = "order-events", groupId = "processing-group")
    public void retry(OrderEvent event) {

        if (event.getQuantity() < 0) {
            throw new RuntimeException("Invalid order");
        }
    }

}
