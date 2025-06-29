import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class MyServiceTest {

    @Test
    public void testMultipleReturns(){
        ExternalAPI mockAPI = mock(ExternalAPI.class);
        StringBuilder sb = new StringBuilder();

        when(mockAPI.getData())
                .thenReturn("A")
                .thenReturn("B")
                .thenReturn("C");

        MyService myService = new MyService(mockAPI);

        sb.append(myService.fetchData());
        sb.append(myService.fetchData());
        sb.append(myService.fetchData());

        assertEquals("ABC", sb.toString());
    }
}