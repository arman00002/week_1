package ObserverPatternExample;

public class Test {
    public static void main(String[] args) {
        StockMarket stockMarket = new StockMarket();

        Observer mobileUser = new MobileApp("Alice");
        Observer webDashboard = new WebApp("FinancePortal");

        stockMarket.register(mobileUser);
        stockMarket.register(webDashboard);

        stockMarket.setPrice(1024.75);
        stockMarket.setPrice(1050.30);

        stockMarket.deregister(mobileUser);

        stockMarket.setPrice(1075.90);
    }
}
