package com.example.user_service_consumer_1.kafka;

import com.example.user_service_consumer_1.event.OrderEvent;
import com.example.user_service_consumer_1.event.OrderStatusEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class OrderListener {

//    @KafkaListener(topics = "order-events", groupId = "user-group")
//    public void consumeOrderStatus(OrderEvent event ){
//        System.out.println("Order Event " + event.getOrderId() +
//                " status: " + event.getStatus());
//    }


    @KafkaListener(topics = "order-status-events", groupId = "user-group")
    public void consumeOrderStatus(OrderStatusEvent event ){
        System.out.println("Order Status event " + event.getOrderId() +
                " status: " + event.getStatus());
    }
}
