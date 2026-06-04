package com.example.order_service_producer_1.OrderController;

import com.example.order_service_producer_1.entity.Order;
import com.example.order_service_producer_1.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService service;

    @PostMapping
    public Order create(@RequestBody Order order) {
        return service.create(order);
    }

}
