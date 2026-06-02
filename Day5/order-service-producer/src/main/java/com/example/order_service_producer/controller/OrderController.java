package com.example.order_service_producer.controller;

import com.example.order_service_producer.dto.OrderDto;
import com.example.order_service_producer.service.OrderProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderProducerService producer;

    @PostMapping("/{orderId}")
    public String createOrder(@PathVariable String orderId) {
        producer.publishOrder(orderId);
        producer.publishStatus("ORDER_CREATED");
        return "Order Event Published";
    }

}
