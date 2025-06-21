package AdapterPatternExample;

public class RazorpayGateway {
    public void makePayment(double amountInINR) {
        System.out.println("Processing Rs." + amountInINR + " via Razorpay.");
    }
}

