package com.kivimango.jalculator;

public interface Operation {
    public String getOperator();
    public int calculate(int param1, int param2);
}
