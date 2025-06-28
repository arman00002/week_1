package com.exercise;

import org.junit.Test;
import static org.mockito.Mockito.*;
import org.mockito.Mockito;

public class VoidExceptionTest {

    @Test(expected = RuntimeException.class)
    public void testVoidMethodThrowsException() {
        ExternalAPI mockApi = Mockito.mock(ExternalAPI.class);

        doThrow(new RuntimeException("Delete failed")).when(mockApi).deleteData();

        MyService service = new MyService(mockApi);

        service.delete();
    }
}
