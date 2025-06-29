package Service;

import Repository.Repository;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class ServiceTest {

    @Test
    public void testService() {
        Repository repository = mock(Repository.class);

        when(repository.getData()).thenReturn("Mock Data");

        Service service = new Service(repository);

        assertEquals("Mock Data", service.getData());
    }
}