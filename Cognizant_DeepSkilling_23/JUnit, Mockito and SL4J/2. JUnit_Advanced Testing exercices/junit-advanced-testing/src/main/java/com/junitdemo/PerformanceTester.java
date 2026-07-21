package com.junitdemo;


public class PerformanceTester {


    public void performTask() {


        try {

            Thread.sleep(1000);

        } catch (InterruptedException e) {

            e.printStackTrace();

        }

    }

}