package DecoratorPatternExample;

public class SMSChannelDecorator extends NotificationWrapper {

    public SMSChannelDecorator(NotificationService notifier) {
        super(notifier);
    }

    @Override
    public void send(String message) {
        super.send(message);
        System.out.println("[SMS] Sent: " + message);
    }
}

