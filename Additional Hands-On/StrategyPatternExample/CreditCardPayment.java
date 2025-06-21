package StrategyPatternExample;

public class CreditCardPayment implements PaymentStrategy {
    private String cardHolder;
    private String cardNumber;

    public CreditCardPayment(String cardHolder, String cardNumber) {
        this.cardHolder = cardHolder;
        this.cardNumber = cardNumber;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid Rs." + amount + " using Credit Card of " + cardHolder);
    }
}

