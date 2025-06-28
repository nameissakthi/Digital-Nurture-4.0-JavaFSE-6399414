import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

public class Main {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        logger.error("This is an error");
        logger.warn("This is a warn");
    }
}