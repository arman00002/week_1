package com.exercise;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

public class MyServiceInteractionTest {

    @Test
    public void testVerifyInteraction() {
        
        ExternalAPI mockApi = Mockito.mock(ExternalAPI.class);

        
        MyService service = new MyService(mockApi);

        
        service.fetchData();

       
        verify(mockApi).getData();
    }
}
