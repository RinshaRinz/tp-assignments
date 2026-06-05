package com.example.order_service_producer_1.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class AppConfig {

    @Bean
    public NewTopic orderEventsTopic() {

        return TopicBuilder
                .name("orders-events")
                .partitions(3)
                .replicas(1)
                .build();
    }

    @Bean
    public NewTopic orderStatusEventsTopic() {

        return TopicBuilder
                .name("order-status-events")
                .partitions(3)
                .replicas(1)
                .build();
    }
}
