package com.kivimango.jalculator.core;

import com.kivimango.jalculator.core.operations.Division;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class DivisionTest {

    private final Division division = new Division();

    @Test
    public void calculationTest() {
        assertEquals("/", division.getOperator());
    }
}
