package com.kivimango.jalculator.model;

import com.kivimango.jalculator.model.operations.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class JalculatorModelImpl implements JalculatorModel {

    @Override
    public int calculate(String input) {
        List<String> operations = Arrays.asList(input.split("[0-9]+"));
        List<String> numbers = Arrays.asList(input.split("[" + Pattern.quote("+-*/") + "]"));
        List<Integer> numbersConverted = convert(numbers);
        int result = calculate(operations, numbersConverted);
        return result;
    }

    private List<Integer> convert( List<String> numbers) {
        List<Integer> numbersConverted = new ArrayList<>();
        for(int i = 0; i < numbers.size(); i++) {
            numbersConverted.add(Integer.valueOf(numbers.get(i)));
        }
        return numbersConverted;
    }

    private int calculate(List<String> operationsParameter, List<Integer> numbersParameter) {
        CalculateStep calculateStep = new CalculateStep(numbersParameter, operationsParameter);
        calculateStep.calculateStep(new Operation[] {new Multiplication(), new Division()});
        calculateStep.calculateStep(new Operation[] {new Addition(), new Substraction()});
        return calculateStep.getResult();
    }
}
