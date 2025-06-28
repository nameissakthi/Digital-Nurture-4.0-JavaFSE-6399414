package com.sakthivel;

import static org.mockito.Mockito.*;

import org.mockito.Mockito;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class MyServiceTest {

    @Test
    public void testVerifyInteraction(){
        ExternalAPI mockAPI = Mockito.mock(ExternalAPI.class);

        when(mockAPI.getData()).thenReturn("Hello Sakthi");

        MyService service = new MyService(mockAPI);

        assertEquals("Hello Sakthi", service.fetchData());
    }
}
