package Service;

import Repository.RestClient;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class ClientServiceTest {

    @Test
    public void testServiceWithMockRestClient() {
        RestClient restClient = mock(RestClient.class);

        when(restClient.getResponse()).thenReturn("Mock Response");

        ClientService service = new ClientService(restClient);

        String result = service.fetchResponse();

        assertEquals("Mock Response", result);
    }
}