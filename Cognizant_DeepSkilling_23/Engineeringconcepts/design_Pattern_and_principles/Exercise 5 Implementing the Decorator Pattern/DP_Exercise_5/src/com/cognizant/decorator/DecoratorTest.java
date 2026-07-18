package com.cognizant.decorator;

public class DecoratorTest {

    public static void main(String[] args) {

        System.out.println("Email Notification:");
        Notifier email = new EmailNotifier();
        email.send("Server is running.");

        System.out.println();

        System.out.println("Email + SMS Notification:");
        Notifier emailSMS =
                new SMSNotifierDecorator(new EmailNotifier());
        emailSMS.send("Server is running.");

        System.out.println();

        System.out.println("Email + SMS + Slack Notification:");
        Notifier allNotifications =
                new SlackNotifierDecorator(
                        new SMSNotifierDecorator(
                                new EmailNotifier()));

        allNotifications.send("Server is running.");
    }
}