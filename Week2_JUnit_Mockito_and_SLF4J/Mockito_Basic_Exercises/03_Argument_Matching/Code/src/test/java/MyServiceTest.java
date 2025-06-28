import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;
import static org.mockito.AdditionalMatchers.*;

class MyServiceTest {

    @Test
    public void testArgumentMatching(){
        ExternalAPI mockAPI = mock(ExternalAPI.class);

        MyService service = new MyService(mockAPI);

        service.setData("sakthivel", 20);

        verify(mockAPI).send("sakthivel", 20);
        verify(mockAPI).send(eq("sakthivel"), anyInt());
        verify(mockAPI).send(anyString(), anyInt());
        verify(mockAPI).send(startsWith("sakthi"), anyInt());
        verify(mockAPI).send(endsWith("vel"), gt(15));

        System.out.println();
    }
}