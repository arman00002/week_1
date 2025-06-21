package ObserverPatternExample;

public class WebApp implements Observer {
    private String dashboard;

    public WebApp(String dashboard) {
        this.dashboard = dashboard;
    }

    @Override
    public void update(double price) {
        System.out.println("[WebApp - " + dashboard + "] Updated: Current price is " + price);
    }
}

