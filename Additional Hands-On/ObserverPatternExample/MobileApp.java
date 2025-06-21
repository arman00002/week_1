package ObserverPatternExample;

public class MobileApp implements Observer {
    private String user;

    public MobileApp(String user) {
        this.user = user;
    }

    @Override
    public void update(double price) {
        System.out.println("[MobileApp - " + user + "] Notified: Stock price is now " + price);
    }
}

