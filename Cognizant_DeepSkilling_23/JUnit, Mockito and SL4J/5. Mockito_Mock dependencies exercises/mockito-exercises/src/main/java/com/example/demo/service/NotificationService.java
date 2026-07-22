package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class NotificationService {


    @Autowired
    private EmailService emailService;



    public String notifyUser(String email, String message) {


        boolean result = emailService.sendEmail(email, message);


        if(result) {
            return "Notification sent";
        }

        return "Notification failed";

    }

}