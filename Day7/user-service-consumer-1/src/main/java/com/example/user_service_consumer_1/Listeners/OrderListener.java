package com.example.user_service_consumer_1.Listeners;

import com.example.user_service_consumer_1.event.OrderStatusEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class OrderListener {

    @KafkaListener(topics = "order-status-event", groupId = "user-group")
    public void consumeOrderStatus(OrderStatusEvent event ){
        System.out.println("Order " + event.getOrderId() +
                " status: " + event.getStatus());
    }
}
