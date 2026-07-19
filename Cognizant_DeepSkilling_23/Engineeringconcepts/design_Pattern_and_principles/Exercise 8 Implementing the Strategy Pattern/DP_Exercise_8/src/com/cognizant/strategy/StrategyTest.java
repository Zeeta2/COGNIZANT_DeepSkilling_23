package com.cognizant.strategy;

public class StrategyTest {

    public static void main(String[] args) {

        PaymentContext context =
                new PaymentContext(new CreditCardPayment());

        System.out.println("Using Credit Card:");
        context.executePayment(5000);

        System.out.println();

        context.setPaymentStrategy(new PayPalPayment());

        System.out.println("Using PayPal:");
        context.executePayment(7500);
    }
}