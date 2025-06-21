public class SmsNotifierDecorator extends NotifierDecorator {
    public SmsNotifierDecorator(Notifier decoratorNotifier){
        super(decoratorNotifier);
    }

    @Override
    public void send(String message){
        super.send(message);
        sendSmsMessage(message);
    }

    public void sendSmsMessage(String message){
        System.out.println("SMS Message : "+message);
    }
}
