package com.kivimango.jalculator;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class AdditionTest {

    @Test
    public void calculationTest() {
        Addition addition = new Addition();
        assertEquals("+", addition.getOperator());
        assertEquals(5, addition.calculate(2, 3));
        assertEquals(6, addition.calculate(9, -3));
        assertEquals(7, addition.calculate(-2, 9));
        assertEquals(-8, addition.calculate(-6, -2));
    }
}
