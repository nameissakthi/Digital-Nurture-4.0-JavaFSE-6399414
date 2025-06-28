import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

public class Main {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        String username = "sakthivel";
        int attempt = 3;

        logger.info("username={}, attempt={}", username, attempt);
        logger.debug("DEBUG: user={}, attempts={}", username, attempt);
        logger.error("ERROR: Log error with user {}", username);
    }
}
