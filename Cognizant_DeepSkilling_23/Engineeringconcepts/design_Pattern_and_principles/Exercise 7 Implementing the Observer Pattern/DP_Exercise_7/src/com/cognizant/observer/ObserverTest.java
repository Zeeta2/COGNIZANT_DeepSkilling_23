package com.cognizant.observer;

public class ObserverTest {

    public static void main(String[] args) {

        StockMarket stockMarket = new StockMarket();

        Observer mobile = new MobileApp("Alice");
        Observer web = new WebApp("Bob");

        stockMarket.registerObserver(mobile);
        stockMarket.registerObserver(web);

        System.out.println("Stock Price Changed:");

        stockMarket.setStock("TCS", 4200.50);

        System.out.println();

        System.out.println("After Removing Web Observer:");

        stockMarket.removeObserver(web);

        stockMarket.setStock("Infosys", 1650.75);
    }
}