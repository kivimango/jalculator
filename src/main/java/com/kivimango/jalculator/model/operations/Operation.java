package com.kivimango.jalculator.model.operations;

public interface Operation {
    String getOperator();
    int calculate(int param1, int param2);
}
