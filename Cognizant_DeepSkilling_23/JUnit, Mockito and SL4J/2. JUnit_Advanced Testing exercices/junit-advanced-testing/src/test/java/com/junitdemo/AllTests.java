package com.junitdemo;


import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;


@Suite
@SelectClasses({
        CalculatorTest.class,
        EvenCheckerTest.class
})


public class AllTests {

}