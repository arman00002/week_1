package Singleton_Pattern;

public class test {
    public static void main(String[] args) {
        logger loggerOne = logger.getInstance();
        logger loggerTwo = logger.getInstance();

        loggerOne.log("This is the first log entry.");
        loggerTwo.log("This is the second log entry.");

        if (loggerOne == loggerTwo) {
            System.out.println("Both logger instances are identical. Singleton confirmed.");
        } else {
            System.out.println("Logger instances differ. Singleton failed.");
        }
    }
}

