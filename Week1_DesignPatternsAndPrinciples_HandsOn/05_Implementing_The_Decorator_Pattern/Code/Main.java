public class Main {
    public static void main(String[] args) {
        Notifier notifier = new EmailNotifier();

        Notifier smsNotifier = new SmsNotifierDecorator(notifier);

        Notifier slackNotifier = new SlackNotifierDecorator(smsNotifier);

        slackNotifier.send("Hello, This is a test notification");
    }    
}