public class SlackNotifierDecorator extends NotifierDecorator {   
    public SlackNotifierDecorator(Notifier decoratorNotifier) {
        super(decoratorNotifier);
    }

    @Override
    public void send(String message){
        super.send(message);
        sendSlackMessage(message);
    }

    public void sendSlackMessage(String message){
        System.out.println("Slack Message : "+message);
    }
}
