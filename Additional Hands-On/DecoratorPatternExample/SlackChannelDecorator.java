package DecoratorPatternExample;

public class SlackChannelDecorator extends NotificationWrapper {

    public SlackChannelDecorator(NotificationService notifier) {
        super(notifier);
    }

    @Override
    public void send(String message) {
        super.send(message);
        System.out.println("[Slack] Sent: " + message);
    }
}

