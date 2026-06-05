package com.example.user_service_consumer_1.controller;


import com.example.user_service_consumer_1.model.OrderNotification;
import com.example.user_service_consumer_1.model.User;
import com.example.user_service_consumer_1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping
    public User createUser(@RequestBody User user){
        User newUser =  service.createUser(user);
        System.out.println("User created : " + newUser);
        return newUser;
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id) {
        return service.getUser(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/{id}/notifications")
    public List<OrderNotification> getNotifications(@PathVariable Long id) {

        return service.getNotifications(id);
    }

}
