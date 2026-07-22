package com.example.demo.service;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;



@ExtendWith(MockitoExtension.class)
public class NotificationServiceTest {



    @Mock
    private EmailService emailService;



    @InjectMocks
    private NotificationService notificationService;



    @Test
    void testNotificationSuccess(){


        when(emailService.sendEmail(
                "test@gmail.com",
                "Hello"))
                .thenReturn(true);



        String result =
                notificationService.notifyUser(
                        "test@gmail.com",
                        "Hello");



        assertEquals(
                "Notification sent",
                result);

    }



}