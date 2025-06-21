package StrategyPatternExample;

public class Test {
     public static void main(String[] args) {
        PaymentContext context = new PaymentContext();

        context.setPaymentStrategy(new CreditCardPayment("Alice Sharma", "4111-xxxx-xxxx-1234"));
        context.executePayment(1500.00);

        System.out.println();

        context.setPaymentStrategy(new PayPalPayment("alice@example.com"));
        context.executePayment(800.00);
    }
}
