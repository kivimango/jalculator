package com.kivimango.jalculator.model.operations;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class AdditionTest {

    private final Addition addition = new Addition();

    @Test
    public void calculationTest() {

        assertEquals("+", addition.getOperator());
    }
}
