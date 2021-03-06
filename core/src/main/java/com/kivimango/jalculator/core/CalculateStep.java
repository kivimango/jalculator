package com.kivimango.jalculator.core;

import com.kivimango.jalculator.core.operations.Operation;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CalculateStep {

    private List<String> operations;
    private List<BigDecimal> numbers;

    public CalculateStep(List<BigDecimal> numbersParameter, List<String> operationsParameter) {
        setNumbers(numbersParameter);
        setOperations(operationsParameter);
    }

    public void calculateStep(Operation[] operationsToExecute) {
        int index = 1;
        while (index < operations.size()) {
            boolean processed = calculatePossibleOperations(index, operationsToExecute);
            if (!processed) {
                index++;
            }
        }
    }

    private boolean calculatePossibleOperations(int index, Operation[] operationsToExecute) {
        boolean processed = false;
        for (int i = 0; i < operationsToExecute.length && !processed; i++) {
            Operation operation = operationsToExecute[i];
            processed = tryOperation(index, operation);
        }
        return processed;
    }

    private boolean tryOperation(int index, Operation operation) {
        boolean processed = false;
        if (operation.getOperator().equals(operations.get(index))) {
            executeOperation(index, operation);
            processed = true;
        }
        return processed;
    }

    private void executeOperation(int index, Operation operation) {
        BigDecimal result = operation.calculate(numbers.get(index - 1), numbers.get(index));
        numbers.set(index - 1, result);
        operations.remove(index);
        numbers.remove(index);
    }

    public void setOperations(List<String> operations) {
        this.operations = new ArrayList<>(operations);
    }

    public void setNumbers(List<BigDecimal> numbers) {
        this.numbers = new ArrayList<>(numbers);
    }

    public BigDecimal getResult() {
        if(numbers.size() != 1) {
            throw new IllegalStateException("Invalid usage of class!");
        }
        return numbers.get(0);
    }
}
