package com.kivimango.jalculator.core.operations;

import java.math.BigDecimal;

public class Substraction implements Operation {

    @Override
    public String getOperator() {
       return "-";
    }

    @Override
    public BigDecimal calculate(BigDecimal param1, BigDecimal param2) {
        return param1.subtract(param2);
    }
}
