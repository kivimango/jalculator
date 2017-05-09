package com.kivimango.jalculator;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class SubstractionTest {

    @Test
    public void calculationTest() {
        Substraction substraction = new Substraction();
        assertEquals("-", substraction.getOperator());
        assertEquals(23, substraction.calculate(56, 33));
        assertEquals(242, substraction.calculate(100, -142));
        assertEquals(-13, substraction.calculate(-6, 7));
        assertEquals(9, substraction.calculate(-12, -21));
    }
}