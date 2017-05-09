package com.kivimango.jalculator.model;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class JalculatorModelTest {

    @Test
    public void calculateAdditionTest() {
        JalculatorModel jalculator = new JalculatorModelImpl();
        String input = "1+2+3";
        int expectedResult = 6;
        assertEquals(expectedResult, jalculator.calculate(input));
    }

    @Test
    public void calculateSubtractionTest() {
        JalculatorModel jalculator = new JalculatorModelImpl();
        String input = "23-89-15";
        int expectedResult = -81;
        assertEquals(expectedResult, jalculator.calculate(input));
    }

    @Test
    public void calculationShouldBeNegativeNumber() {
        JalculatorModel jalculator = new JalculatorModelImpl();
        String input = "65-113";
        int expectedResult = -48;
        assertEquals(expectedResult, jalculator.calculate(input));
    }


    @Test
    public void calculateMultiplicationTest() {
        JalculatorModel jalculator = new JalculatorModelImpl();
        String input = "1*2*3";
        int expectedResult = 6;
        assertEquals(expectedResult, jalculator.calculate(input));
    }

    @Test
    public void calculateDivisonTest() {
        JalculatorModel jalculator = new JalculatorModelImpl();
        String input = "35/7";
        int expectedResult = 5;
        assertEquals(expectedResult, jalculator.calculate(input));
    }

    @Test
    public void calculateMixedOperationsTest() {
        JalculatorModel jalculator = new JalculatorModelImpl();
        String input = "1+2*3";
        int expectedResult = 7;
        assertEquals(expectedResult, jalculator.calculate(input));
    }

    @Test(expected=ArithmeticException.class)
    public void calculationShouldThrowArithmeticException() {
        JalculatorModel jalculator = new JalculatorModelImpl();
        String input = "83/0";
        int expectedResult = 0;
        assertEquals(expectedResult, jalculator.calculate(input));
    }
}
