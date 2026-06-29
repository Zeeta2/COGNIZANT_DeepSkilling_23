package com.cognizant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ParameterizedLoggingExample {
    private static final Logger logger =
            LoggerFactory.getLogger(ParameterizedLoggingExample.class);
    public static void main(String[] args) {
    	String username = "Alice";
        int age = 25;
        logger.info("User Name: {}", username);
        logger.info("Age: {}", age);
        logger.warn("User {} has only {} login attempts remaining.", username, 2);
        logger.error("Login failed for user: {}", username);
    }
}