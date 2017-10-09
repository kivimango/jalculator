package com.kivimango.jalculator.core;

import com.kivimango.jalculator.core.operations.Addition;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class AdditionTest {

    private final Addition addition = new Addition();

    @Test
    public void calculationTest() {

        assertEquals("+", addition.getOperator());
    }
}
