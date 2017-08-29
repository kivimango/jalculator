package com.kivimango.jalculator.model.operations;

import java.math.BigDecimal;
import com.kivimango.jalculator.model.operations.Operation;

public class Addition implements Operation {

    @Override
    public String getOperator() {
       return "+";
    }

    @Override
    public BigDecimal calculate(BigDecimal param1, BigDecimal param2) {
       return param1.add(param2);
    }
}
