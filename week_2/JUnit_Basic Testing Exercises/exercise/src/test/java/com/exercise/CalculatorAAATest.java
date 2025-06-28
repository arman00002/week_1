package com.exercise;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorAAATest {

    private Calculator calculator;

    @Before
    public void setUp() {
        calculator = new Calculator();  
        System.out.println("Setup: Calculator initialized");
    }

    @Test
    public void testAddition() {
        int result = calculator.add(2, 3);

        assertEquals("Expected sum of 2 and 3 is 5", 5, result);
    }

    @After
    public void tearDown() {
        System.out.println("Teardown: Test completed");
    }
}
