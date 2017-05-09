package com.kivimango.jalculator;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MultiplicationTest {

    @Test
    public void calculationTest() {
        Multiplication multiplication = new Multiplication();
        assertEquals("*", multiplication.getOperator());
        assertEquals(16, multiplication.calculate(2, 8));
        assertEquals(-64, multiplication.calculate(8, -8));
        assertEquals(-24, multiplication.calculate(12, -2));
        assertEquals(32, multiplication.calculate(-4, -8));
    }
}
