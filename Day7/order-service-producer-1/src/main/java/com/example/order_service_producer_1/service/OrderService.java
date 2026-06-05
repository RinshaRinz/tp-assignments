package com.example.order_service_producer_1.service;

import com.example.order_service_producer_1.entity.CustomerOrder;
import com.example.order_service_producer_1.event.OrderEvent;
import com.example.order_service_producer_1.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    @Autowired
    private KafkaTemplate<String, OrderEvent> kafkaTemplate;

    public CustomerOrder create(CustomerOrder customerOrder) {
        customerOrder.setStatus("CREATED");
        CustomerOrder savedCustomerOrder = repository.save(customerOrder);

        OrderEvent event = new OrderEvent(
                savedCustomerOrder.getOrderId(),
                savedCustomerOrder.getUserId(),
                savedCustomerOrder.getProductName(),
                savedCustomerOrder.getQuantity(),
                savedCustomerOrder.getStatus()
        );
        kafkaTemplate.send("order-events", event);
        return savedCustomerOrder;
    }

    public List<CustomerOrder> getOrders() {
        return repository.findAll();
    }

    public Optional<CustomerOrder> getOrder(Long id) {
        return repository.findById(id);
    }

}
