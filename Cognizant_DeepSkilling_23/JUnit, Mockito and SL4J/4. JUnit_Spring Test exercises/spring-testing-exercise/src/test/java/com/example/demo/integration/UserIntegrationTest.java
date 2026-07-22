package com.example.demo.integration;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;

@SpringBootTest
public class UserIntegrationTest {

    @Autowired
    private UserService userService;

    @Test
    void testSaveAndFetchUser() {

        User user = new User(1L, "John");

        userService.saveUser(user);

        User result = userService.getUserById(1L);

        assertEquals("John", result.getName());
    }
}