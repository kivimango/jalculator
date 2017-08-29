package com.kivimango.jalculator.model;

import com.kivimango.jalculator.model.operations.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class JalculatorModelImpl implements CalculationModel {

    @Override
    public BigDecimal calculate(String input) {
        List<String> operations = Arrays.asList(input.split("[0-9\\.]+"));
        List<String> numbers = Arrays.asList(input.split("[" + Pattern.quote("+-*/") + "]"));
        List<BigDecimal> numbersConverted = convert(numbers);
        return calculate(operations, numbersConverted);
    }

    private List<BigDecimal> convert( List<String> numbers) {
        List<BigDecimal> numbersConverted = new ArrayList<>();
        for (String number : numbers) {
            numbersConverted.add(new BigDecimal(number));
        }
        return numbersConverted;
    }

    private BigDecimal calculate(List<String> operations, List<BigDecimal> numbers) {
        CalculateStep step = new CalculateStep(numbers, operations);
        step.calculateStep(new Operation[] {new Multiplication(), new Division()});
        step.calculateStep(new Operation[] {new Addition(), new Substraction()});
        return step.getResult();
    }
}
