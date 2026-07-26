package com.example.orderservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.orderservice.client.UserClient;
import com.example.orderservice.dto.UserDTO;
import com.example.orderservice.entity.Order;
import com.example.orderservice.repository.OrderRepository;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final UserClient userClient;

    public OrderService(OrderRepository orderRepository,
                        UserClient userClient) {
        this.orderRepository = orderRepository;
        this.userClient = userClient;
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order getOrderById(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));
    }

    public Order saveOrder(Order order) {

        UserDTO user = userClient.getUserById(order.getUserId());

        if (user == null) {
            throw new RuntimeException("User not found");
        }

        return orderRepository.save(order);
    }
}