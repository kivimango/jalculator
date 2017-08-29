package com.kivimango.jalculator.model.operations;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class DivisionTest {

    private final Division division = new Division();

    @Test
    public void calculationTest() {
        assertEquals("/", division.getOperator());
    }
}
