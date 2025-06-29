import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class PerformanceTest {

    @Test
    public void goodPerformanceTest(){
        Performance performance = new Performance();

        assertTimeout(Duration.ofSeconds(5), performance::task);
    }
}