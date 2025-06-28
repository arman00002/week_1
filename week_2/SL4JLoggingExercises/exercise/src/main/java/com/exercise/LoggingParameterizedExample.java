package main.java.com.exercise;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingParameterizedExample {
    private static final Logger logger = LoggerFactory.getLogger(LoggingParameterizedExample.class);

    public static void main(String[] args) {
        String userName = "Arman";
        int accountId = 10245;
        double balance = 5234.75;

        logger.info("User {} logged in with Account ID {}", userName, accountId);
        logger.warn("User {} has low balance: {}", userName, balance);
        logger.error("Failed to process transaction for user {} with ID {}", userName, accountId);
    }
}
