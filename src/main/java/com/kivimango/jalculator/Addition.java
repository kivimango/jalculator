package com.kivimango.jalculator;

public class Addition implements Operation {

    @Override
    public String getOperator() {
       return "+";
    }

    @Override
    public int calculate(int param1, int param2) {
        return param1 + param2;
    }
}
