package com.junitdemo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


public class CalculatorTest {


    Calculator calculator = new Calculator();


    @Test
    void testAddition(){

        assertEquals(10, calculator.add(5,5));

    }


    @Test
    void testMultiplication(){

        assertEquals(20, calculator.multiply(4,5));

    }

}