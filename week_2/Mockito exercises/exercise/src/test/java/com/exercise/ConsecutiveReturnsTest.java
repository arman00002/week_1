package com.exercise;

import org.junit.Test;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

public class ConsecutiveReturnsTest {

    @Test
    public void testConsecutiveReturns() {
        ExternalAPI mockApi = mock(ExternalAPI.class);

        when(mockApi.getData()).thenReturn("First").thenReturn("Second").thenReturn("Third");

        MyService service = new MyService(mockApi);
        String[] result = service.fetchMultipleTimes(3);

        assertEquals("First", result[0]);
        assertEquals("Second", result[1]);
        assertEquals("Third", result[2]);

        verify(mockApi, times(3)).getData();
    }
}
