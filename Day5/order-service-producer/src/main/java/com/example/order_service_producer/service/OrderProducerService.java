package com.example.order_service_producer.service;

import com.example.order_service_producer.dto.OrderDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class OrderProducerService {

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    public void publishOrder(String order){
        kafkaTemplate.send("order-events", order);
    }

    public void publishStatus(String status){
        kafkaTemplate.send("order-status", status);
    }


    public void sendOrder(OrderDto order) {
        kafkaTemplate.send("order-events-1", order);
        System.out.println("Sent Order: " + order.getOrderId());
    }


}
