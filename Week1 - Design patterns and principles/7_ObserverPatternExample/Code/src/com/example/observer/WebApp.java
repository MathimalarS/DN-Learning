package com.example.observer;

public class WebApp implements Observer {

    @Override
    public void update(String stockSymbol, double stockPrice) {
        System.out.println("WebApp: Stock " + stockSymbol + " price updated to $" + stockPrice);
    }
}
