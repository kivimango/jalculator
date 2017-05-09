package com.kivimango.jalculator.model.operations;

public class Substraction implements Operation {

    @Override
    public String getOperator() {
       return "-";
    }

    @Override
    public int calculate(int param1, int param2) {
        return param1 - param2;
    }
}
