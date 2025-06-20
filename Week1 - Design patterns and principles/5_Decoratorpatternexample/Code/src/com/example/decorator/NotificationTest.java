
public class NotificationTest {

    public static void main(String[] args) {
        // Basic email notifier
        Notifier emailNotifier = new EmailNotifier();
        emailNotifier.send("Hello via Email!");

        System.out.println();

        Notifier emailAndSMSNotifier = new SMSNotifierDecorator(emailNotifier);
        emailAndSMSNotifier.send("Hello via Email and SMS!");

        System.out.println();
        Notifier multiChannelNotifier = new SlackNotifierDecorator(emailAndSMSNotifier);
        multiChannelNotifier.send("Hello via Email, SMS, and Slack!");
    }
}
