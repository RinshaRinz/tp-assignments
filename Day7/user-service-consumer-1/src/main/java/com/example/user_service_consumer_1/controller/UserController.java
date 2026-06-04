package com.example.user_service_consumer_1.controller;


import com.example.user_service_consumer_1.entity.User;
import com.example.user_service_consumer_1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public User get(@PathVariable Long id) {
        return service.get(id);
    }

}
