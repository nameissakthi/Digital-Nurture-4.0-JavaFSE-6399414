public class UserService {
    private final NotificationService notificationService;

    public UserService(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    public void registerUser(String username) {
        notificationService.sendEmail("Welcome " + username + "!");
    }
}
