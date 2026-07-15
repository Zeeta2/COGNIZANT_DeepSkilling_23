package com.example.jwt_demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.jwt_demo.security.JwtTokenProvider;

@RestController
public class LoginController {

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @PostMapping("/login")
    public String login(@RequestParam String username) {

        return jwtTokenProvider.createToken(username);
    }
}