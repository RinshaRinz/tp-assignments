package com.example.notification_service_consumer.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    @KafkaListener(
            topics = "orders-topic",
            groupId = "notification-group"
    )
    public void consume(String message){
        System.out.println("Notification Service Received : " + message);
    }
}
