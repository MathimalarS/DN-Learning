package com.example.observer;

public class MobileApp implements Observer {

    @Override
    public void update(String stockSymbol, double stockPrice) {
        System.out.println("MobileApp: Stock " + stockSymbol + " price updated to $" + stockPrice);
    }
}
