import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class ServiceTest {

    @Test
    public void testServiceWithMultipleReturns() {
        Repository mockRepo = mock(Repository.class);

        when(mockRepo.getData())
                .thenReturn("First Data")
                .thenReturn("Second Data");

        Service service = new Service(mockRepo);

        String firstResult = service.processData();
        String secondResult = service.processData();

        assertEquals("First Data", firstResult);
        assertEquals("Second Data", secondResult);
    }
}