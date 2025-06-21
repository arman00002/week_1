package AdapterPatternExample;

public class PayPalGateway {
    public void sendMoney(double usdAmount) {
        System.out.println("Processing $" + usdAmount + " via PayPal.");
    }
}

