package ObserverPatternExample;

import java.util.ArrayList;
import java.util.List;

public class StockMarket implements Stock {
    private List<Observer> observers = new ArrayList<>();
    private double currentPrice;

    @Override
    public void register(Observer o) {
        observers.add(o);
    }

    @Override
    public void deregister(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer o : observers) {
            o.update(currentPrice);
        }
    }

    public void setPrice(double price) {
        this.currentPrice = price;
        System.out.println("\n[StockMarket] Price updated to: " + price);
        notifyObservers();
    }
}
