package com.example.user_service_consumer_1.service;

import com.example.user_service_consumer_1.entity.User;
import com.example.user_service_consumer_1.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepo repo;

    public User createUser(User user){
        return repo.save(user);
    }


    public User get(Long id) {
        return repo.findById(id).orElseThrow();
    }

}
