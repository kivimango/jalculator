package com.kivimango.jalculator.model.operations;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class DivisionTest {

    @Test
    public void calculationTest() {
        Division division = new Division();
        assertEquals("/", division.getOperator());
        assertEquals(10, division.calculate(100, 10));
        assertEquals(-30, division.calculate(90, -3));
        assertEquals(-4, division.calculate(-12, 3));
        assertEquals(8, division.calculate(-88, -11));
    }
}
