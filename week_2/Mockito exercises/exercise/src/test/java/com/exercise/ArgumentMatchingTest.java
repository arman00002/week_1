package com.exercise;

import org.junit.Test;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

public class ArgumentMatchingTest {

    @Test
    public void testMethodCallVerification() {
        ExternalAPI mockApi = mock(ExternalAPI.class);

        
        when(mockApi.getData()).thenReturn("Mock Data");

        MyService service = new MyService(mockApi);
        String result = service.fetchData();

        assertEquals("Mock Data", result);

        
        verify(mockApi).getData();
    }
}
