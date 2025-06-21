package Singleton_Pattern;

public class logger {

    private static logger loggerInstance;

    private logger() {
        System.out.println("Logger initialized.");
    }

    public static logger getInstance() {
        if (loggerInstance == null) {
            synchronized (logger.class) {
                if (loggerInstance == null) {
                    loggerInstance = new logger();
                }
            }
        }
        return loggerInstance;
    }
    public void log(String message) {
        System.out.println("[LOG]: " + message);
    }
}
