package com.training.notification_service.controller;

import com.training.notification_service.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notification")
public class NotificationController {

    @Autowired
    private NotificationService service;

    @PostMapping("/email")
    public String sendEmail(@RequestBody String message){
        return service.sendEmail(message);
    }

    @PostMapping("/sms")
    public String sendSms(@RequestBody String message){
        return service.sendSMS(message);
    }



}
