package com.example.observer;

public class ObserverPatternTest {

    public static void main(String[] args) {
        StockMarket stockMarket = new StockMarket();

        Observer mobileApp = new MobileApp();
        Observer webApp = new WebApp();

        stockMarket.registerObserver(mobileApp);
        stockMarket.registerObserver(webApp);

        stockMarket.setStockPrice("AAPL", 150.00);
        stockMarket.setStockPrice("GOOGL", 2800.50);

        stockMarket.removeObserver(mobileApp);

        stockMarket.setStockPrice("MSFT", 299.99);
    }
}
