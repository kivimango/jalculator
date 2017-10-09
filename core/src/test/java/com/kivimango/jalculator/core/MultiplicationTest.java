package com.kivimango.jalculator.core;

import com.kivimango.jalculator.core.operations.Multiplication;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MultiplicationTest {

    private final Multiplication multiplication = new Multiplication();

    @Test
    public void calculationTest() {
        assertEquals("*", multiplication.getOperator());
    }
}
