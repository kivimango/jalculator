package com.kivimango.jalculator.model.operations;

import java.math.BigDecimal;

public class Division implements Operation {

    @Override
    public String getOperator() {
       return "/";
    }

    @Override
    public BigDecimal calculate(BigDecimal param1, BigDecimal param2) {
        return param1.divide(param2);
    }
}