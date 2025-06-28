package com.exercise; 

import org.junit.Test;
import static org.junit.Assert.*;

public class AssertionTest {

    @Test
    public void testAssertions() {
        int expected = 5;
        int actual = 2 + 3;
        assertEquals("Expected 2 + 3 to equal 5", expected, actual);

        
        assertTrue("Expected 5 to be greater than 3", 5 > 3);

       
        assertFalse("Expected 5 < 3 to be false", 5 < 3);

       
        Object empty = null;
        assertNull("Object should be null", empty);

        Object filled = new Object();
        assertNotNull("Object should not be null", filled);
    }
}

