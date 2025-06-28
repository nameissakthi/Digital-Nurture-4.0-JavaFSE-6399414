import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

public class Main {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        logger.debug("Debugging info - useful for development.");
        logger.info("Informational message - routine event.");
        logger.warn("Warning - something unexpected might happen.");
        logger.error("Error - something failed!");
    }

}
