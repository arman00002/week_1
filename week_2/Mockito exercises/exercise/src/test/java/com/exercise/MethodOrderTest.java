package com.exercise;

import org.junit.Test;
import static org.mockito.Mockito.*;
import org.mockito.InOrder;

public class MethodOrderTest {

    @Test
    public void testMethodCallOrder() {
        ExternalAPI mockApi = mock(ExternalAPI.class);
        MyService service = new MyService(mockApi);

        service.process();

        InOrder inOrder = inOrder(mockApi);
        inOrder.verify(mockApi).logAccess();
        inOrder.verify(mockApi).performAction();
        inOrder.verify(mockApi).getData();
    }
}
