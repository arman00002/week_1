package com.exercise;

import org.junit.Test;
import static org.junit.Assert.*;

public class CalculatorBasicTest {

    Calculator calculator = new Calculator();

    @Test
    public void testAddition() {
        assertEquals(10, calculator.add(7, 3));
    }

    @Test
    public void testSubtraction() {
        assertEquals(4, calculator.subtract(10, 6));
    }

    @Test
    public void testMultiplication() {
        assertEquals(20, calculator.multiply(4, 5));
    }

    @Test
    public void testDivision() {
        assertEquals(3, calculator.divide(9, 3));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDivisionByZero() {
        calculator.divide(10, 0);
    }
}

