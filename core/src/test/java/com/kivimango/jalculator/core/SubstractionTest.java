package com.kivimango.jalculator.core;

import com.kivimango.jalculator.core.operations.Substraction;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class SubstractionTest {

    private final Substraction subtraction = new Substraction();

    @Test
    public void calculationTest() {
        assertEquals("-", subtraction.getOperator());
    }
}