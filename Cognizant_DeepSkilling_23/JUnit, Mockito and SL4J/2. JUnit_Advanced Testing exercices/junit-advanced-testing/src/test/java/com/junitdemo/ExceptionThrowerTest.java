package com.junitdemo;


import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;


public class ExceptionThrowerTest {


    ExceptionThrower exceptionThrower = new ExceptionThrower();


    @Test
    void testException() {


        assertThrows(
                IllegalArgumentException.class,
                () -> exceptionThrower.throwException()
        );


    }

}