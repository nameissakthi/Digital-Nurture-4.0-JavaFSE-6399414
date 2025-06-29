import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class NetworkServiceTest {

    @Test
    public void testServiceWithMockNetworkClient() {
        NetworkClient mockNetwork = mock(NetworkClient.class);

        when(mockNetwork.connect()).thenReturn("Mock Server");

        NetworkService service = new NetworkService(mockNetwork);

        String result = service.connectServer();

        assertEquals("Mock Server", result);
    }
}