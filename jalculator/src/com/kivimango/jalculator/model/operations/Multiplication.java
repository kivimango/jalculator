package com.kivimango.jalculator.model.operations;

import java.math.BigDecimal;

public class Multiplication implements Operation {

    @Override
    public String getOperator() {
       return "*";
    }

    @Override
    public BigDecimal calculate(BigDecimal param1, BigDecimal param2) {
        return param1.multiply(param2);
    }
}
