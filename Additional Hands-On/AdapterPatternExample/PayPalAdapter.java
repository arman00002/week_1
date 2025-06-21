package AdapterPatternExample;

public class PayPalAdapter implements PaymentProcessor {
    private PayPalGateway paypal;

    public PayPalAdapter(PayPalGateway paypal) {
        this.paypal = paypal;
    }

    @Override
    public void processPayment(double amount) {
        double usd = amount / 83.0; 
        paypal.sendMoney(usd);
    }
}

