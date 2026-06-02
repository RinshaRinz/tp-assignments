package com.training.notification_service.service;

import org.springframework.stereotype.Service;

@Service
public class NotificationService {


    public String sendEmail(String message) {
        return "Email sent successfully: " + message;
    }

    public String sendSMS(String message) {
        return "SMS sent successfully: " + message;
    }

}
