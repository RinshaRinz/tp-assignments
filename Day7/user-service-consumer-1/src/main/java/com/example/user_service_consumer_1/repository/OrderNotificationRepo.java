package com.example.user_service_consumer_1.repository;

import com.example.user_service_consumer_1.model.OrderNotification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderNotificationRepo  extends JpaRepository<OrderNotification, Long> {
    List<OrderNotification> findByOrderId(Long orderId);
}
