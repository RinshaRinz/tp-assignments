package com.example.order_service_producer_1.service;

import com.example.order_service_producer_1.entity.Order;
import com.example.order_service_producer_1.event.OrderEvent;
import com.example.order_service_producer_1.repo.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    @Autowired
    private KafkaTemplate<String, OrderEvent> kafkaTemplate;

    public Order create(Order order) {

        order.setStatus("CREATED");
        Order savedOrder = repository.save(order);

        OrderEvent event = new OrderEvent(
                savedOrder.getOrderId(),
                savedOrder.getUserId(),
                savedOrder.getProductName(),
                savedOrder.getQuantity(),
                savedOrder.getStatus()
        );

        kafkaTemplate.send("order-events", event);
        return savedOrder;
    }

}
