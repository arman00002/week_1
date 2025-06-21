package DecoratorPatternExample;

public class App {
    public static void main(String[] args) {
        NotificationService emailOnly = new BaseEmailService();
        emailOnly.send("Welcome to our platform!");

        System.out.println();

        NotificationService smsEnabled = new SMSChannelDecorator(new BaseEmailService());
        smsEnabled.send("Your account has been updated.");

        System.out.println();

        NotificationService multiChannel = new SlackChannelDecorator(
                                              new SMSChannelDecorator(
                                                  new BaseEmailService()));
        multiChannel.send("System maintenance scheduled tonight.");
    }
}
