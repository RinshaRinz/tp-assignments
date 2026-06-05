package com.example.order_service_producer_1.Controller;

import com.example.order_service_producer_1.entity.CustomerOrder;
import com.example.order_service_producer_1.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService service;

    @PostMapping
    public CustomerOrder create(@RequestBody CustomerOrder customerOrder) {
        return service.create(customerOrder);
    }

    @GetMapping
    public List<CustomerOrder> getOrders() {
        return service.getOrders();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerOrder> getOrder(@PathVariable Long id) {
        return service.getOrder(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
