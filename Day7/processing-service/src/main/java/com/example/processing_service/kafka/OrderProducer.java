package com.example.processing_service.kafka;

import com.example.processing_service.event.OrderStatusEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Service;

@Service
public class OrderProducer {

    @Autowired
    private KafkaTemplate<String, OrderStatusEvent> kafkaTemplate;

    public void produceOrderEvent(OrderStatusEvent orderStatusEvent){
        kafkaTemplate.send("order-status-events", orderStatusEvent);
    }

}
