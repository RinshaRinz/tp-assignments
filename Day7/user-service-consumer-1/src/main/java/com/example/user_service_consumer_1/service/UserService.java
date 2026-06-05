package com.example.user_service_consumer_1.service;

import com.example.user_service_consumer_1.model.OrderNotification;
import com.example.user_service_consumer_1.model.User;
import com.example.user_service_consumer_1.event.OrderStatusEvent;
import com.example.user_service_consumer_1.repository.OrderNotificationRepo;
import com.example.user_service_consumer_1.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private OrderNotificationRepo notificationRepo;

    public User createUser(User user){
        return userRepo.save(user);
    }

    public Optional<User> getUser(Long id) {
        return userRepo.findById(id);
    }

    public void saveNotification(OrderStatusEvent event) {
        notificationRepo.save(new OrderNotification(
                event.getOrderId(),
                event.getStatus()
        ));
    }

    public List<OrderNotification> getNotifications(Long orderId) {
        return notificationRepo.findByOrderId(orderId);
    }

}
