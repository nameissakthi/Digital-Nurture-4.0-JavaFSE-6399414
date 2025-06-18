public class Logger {
    private static Logger loggerInstance;

    private String username;
    private String password;
    
    private Logger() {}

    public static Logger getInstance() {
        if(loggerInstance == null) {
            loggerInstance = new Logger();
        }

        return loggerInstance;
    }

    public void setUsernameAndPassword(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void displayCredentials() {
        System.out.println("Username: " + username);
        System.out.println("Password: " + password);
    }
}
