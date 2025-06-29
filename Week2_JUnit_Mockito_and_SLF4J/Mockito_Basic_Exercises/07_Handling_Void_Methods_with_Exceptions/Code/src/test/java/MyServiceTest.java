import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class MyServiceTest {

    @Test
    public void testHandlingVoidMethodsWithExceptions(){
        Notification notification = mock(Notification.class);

        doThrow(new RuntimeException("Notification Alert Failed"))
            .when(notification).alert();

        MyService myService = new MyService(notification);

        assertThrows(RuntimeException.class, myService::notifyUser);

        verify(notification).alert();
    }
}