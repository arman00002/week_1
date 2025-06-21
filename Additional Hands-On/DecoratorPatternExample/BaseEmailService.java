package DecoratorPatternExample;

public class BaseEmailService implements NotificationService {
    @Override
    public void send(String message) {
        System.out.println("[Email] Sent: " + message);
    }
}

