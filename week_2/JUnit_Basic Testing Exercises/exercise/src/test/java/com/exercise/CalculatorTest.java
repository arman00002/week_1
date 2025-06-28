package com.exercise;
import org.junit.Test;
import static org.junit.Assert.*;

public class CalculatorTest {

    @Test
    public void testAddition() {
    assertEquals(8, App.add(5, 3));
}

}