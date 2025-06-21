package AdapterPatternExample;

public class Test {
    public static void main(String[] args) {
        PaymentProcessor razorpayProcessor = new RazorpayAdapter(new RazorpayGateway());
        razorpayProcessor.processPayment(2000); 
        System.out.println();
        PaymentProcessor paypalProcessor = new PayPalAdapter(new PayPalGateway());
        paypalProcessor.processPayment(2000); 
    }
}
