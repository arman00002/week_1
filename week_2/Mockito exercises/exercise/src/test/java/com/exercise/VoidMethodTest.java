package com.exercise;

import org.junit.Test;
import static org.mockito.Mockito.*;

public class VoidMethodTest {

    @Test
    public void testVoidMethodInteraction() {
        ExternalAPI mockApi = mock(ExternalAPI.class);

        doNothing().when(mockApi).performAction();

        MyService service = new MyService(mockApi);
        service.executeAction();

        verify(mockApi).performAction();  
    }
}
