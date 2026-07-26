package com.example.paymentservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.paymentservice.service.PaymentService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping("/payment")
    @CircuitBreaker(name = "paymentService", fallbackMethod = "fallbackPayment")
    public String payment() {
        return paymentService.processPayment();
    }

    public String fallbackPayment(Exception ex) {
        return "Payment Service is temporarily unavailable. Please try again later.";
    }
}