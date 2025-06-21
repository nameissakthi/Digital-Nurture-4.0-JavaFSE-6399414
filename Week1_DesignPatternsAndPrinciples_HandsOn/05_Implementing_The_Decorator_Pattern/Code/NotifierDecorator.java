public class NotifierDecorator implements Notifier {
    Notifier decoratorNotifier;
    
    public NotifierDecorator(Notifier decoratorNotifier){
        this.decoratorNotifier = decoratorNotifier;
    }

    @Override
    public void send(String message){
        decoratorNotifier.send(message);
    }
}
