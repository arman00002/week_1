package main.java.com.exercise;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingWithAppenders {
    private static final Logger logger = LoggerFactory.getLogger(LoggingWithAppenders.class);

    public static void main(String[] args) {
        logger.info("Application started.");
        logger.debug("Debugging application workflow.");
        logger.warn("This is a warning message.");
        logger.error("This is an error message.");
    }
}
