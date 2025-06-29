public class MyService {
    private final Notification notification;

    public MyService(Notification notification) {
        this.notification = notification;
    }

    public void notifyUser() {
        notification.alert();
    }
}
