package com.kivimango.jalculator;

import java.util.regex.Pattern;

public class JalculatorModelImpl implements JalculatorModel {

    @Override
    public int calculate(String input) {
        String[] operations = input.split("[0-9]+");
        String[] numbers = input.split("[" + Pattern.quote("+-*/") + "]");
        int[] numbersConverted = convert(numbers);
        int result = calculate(operations, numbersConverted);
        return result;
    }

    private int[] convert(String[] numbers) {
        int[] numbersConverted = new int[numbers.length];
        for(int i = 0; i < numbers.length; i++) {
            numbersConverted[i] = Integer.valueOf(numbers[i]);
        }
        return numbersConverted;
    }

    private int calculate(String[] operations, int[] numbers) {
        int length = operations.length;
        int index = 1;
        while (index < length) {
            if ("*".equals(operations[index])) {
                numbers[index - 1] = numbers[index - 1] * numbers[index];
                remove(numbers, length, index);
                remove(operations, length, index);
                length--;
            } else if ("/".equals(operations[index])) {
                numbers[index - 1] = numbers[index - 1] / numbers[index];
                remove(numbers, length, index);
                remove(operations, length, index);
                length--;
            } else {
                index++;
            }
        }

        index = 1;
        while (index < length) {
            if ("+".equals(operations[index])) {
                numbers[index - 1] = numbers[index - 1] + numbers[index];
                remove(numbers, length, index);
                remove(operations, length, index);
                length--;
            } else if ("-".equals(operations[index])) {
                numbers[index - 1] = numbers[index - 1] - numbers[index];
                remove(numbers, length, index);
                remove(operations, length, index);
                length--;
            } else {
                index++;
            }
        }
        return numbers[0];
    }

    private void remove(int[] numbers, int length, int index) {
        for (int j = index; j < length - 1; j++) {
            numbers[j] = numbers[j + 1];
        }
    }

    private void remove(String[] operations, int length, int index) {
        for (int j = index; j < length - 1; j++) {
            operations[j] = operations[j + 1];
        }
    }
}
