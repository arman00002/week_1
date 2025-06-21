package FinancialForecasting;

public class Forecast {

    public static double calculateFutureValue(double initialValue, double rate, int years) {
        if (years == 0) {
            return initialValue;
        }
        return calculateFutureValue(initialValue, rate, years - 1) * (1 + rate);
    }

    public static void main(String[] args) {
        double initialValue = 10000;  
        double growthRate = 0.08;     
        int futureYears = 5;

        double futureValue = calculateFutureValue(initialValue, growthRate, futureYears);

        System.out.printf("Predicted value after %d years: %.2f\n", futureYears, futureValue);
    }
}

