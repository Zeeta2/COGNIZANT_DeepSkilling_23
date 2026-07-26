package com.example.paymentservice.service;

import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    public String processPayment() {

        throw new RuntimeException("Third-party payment service is down");

    }

}