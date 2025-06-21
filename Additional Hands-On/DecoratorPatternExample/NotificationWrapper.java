package DecoratorPatternExample;

public abstract class NotificationWrapper implements NotificationService {
    protected NotificationService notifier;

    public NotificationWrapper(NotificationService notifier) {
        this.notifier = notifier;
    }

    @Override
    public void send(String message) {
        notifier.send(message);
    }
}

