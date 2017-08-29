package com.kivimango.jalculator.model.operations;

import com.kivimango.jalculator.model.CalculationModel;
import com.kivimango.jalculator.model.JalculatorModelImpl;
import org.junit.Test;
import java.math.BigDecimal;
import static org.junit.Assert.assertEquals;

/**
 * Unit tests for the model.
 *
 * @author kivimango
 */

public class JalculatorModelTest {

    private CalculationModel model = new JalculatorModelImpl();

    @Test
    public void calculateAdditionTest() {
        String input = "1+2+3";
        BigDecimal expected = new BigDecimal(6);
        assertEquals(expected, model.calculate(input));
    }

    @Test
    public void calculateSubtractionTest() {
        String input = "23-89-15";
        BigDecimal expected = new BigDecimal(-81);
        assertEquals(expected, model.calculate(input));
    }

    @Test
    public void calculationShouldBeNegativeNumber() {
        String input = "65-113";
        BigDecimal expected = new BigDecimal(-48);
        assertEquals(expected, model.calculate(input));
    }

    @Test
    public void calculateMultiplicationTest() {
        String input = "1*2*3";
        BigDecimal expected = new BigDecimal(6);
        assertEquals(expected, model.calculate(input));
    }

    @Test
    public void calculateDivisionTest() {
        String input = "35/7";
        BigDecimal expected = new BigDecimal(5);
        assertEquals(expected, model.calculate(input));
    }

    @Test
    public void calculateMixedOperationsTest() {
        String input = "1+2*3";
        BigDecimal expected = new BigDecimal(7);
        assertEquals(expected, model.calculate(input));
    }

    @Test(expected=ArithmeticException.class)
    public void calculationShouldThrowArithmeticException() {
        String input = "83/0";
        BigDecimal expected = new BigDecimal(0);
        assertEquals(expected, model.calculate(input));
    }

    @Test(expected=NumberFormatException.class)
    public void calculationShouldThrowNumberFormatException() {
        String invalidInput = "a+b+c";
        BigDecimal expected = new BigDecimal(0);
        assertEquals(expected, model.calculate(invalidInput));
    }
}
