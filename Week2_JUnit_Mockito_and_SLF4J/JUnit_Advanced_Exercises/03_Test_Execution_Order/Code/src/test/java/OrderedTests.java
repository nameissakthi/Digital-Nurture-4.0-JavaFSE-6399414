import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.class)
public class OrderedTests {

    @Order(1)
    @Test
    public void testA() {
        System.out.println("testA");
    }

    @Order(3)
    @Test
    public void testB() {
        System.out.println("testB");
    }

    @Order(2)
    @Test
    public void testC() {
        System.out.println("testC");
    }
}
