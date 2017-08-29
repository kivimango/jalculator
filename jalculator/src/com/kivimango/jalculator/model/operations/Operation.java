package com.kivimango.jalculator.model.operations;

import java.math.BigDecimal;

public interface Operation {
    String getOperator();
    BigDecimal calculate(BigDecimal param1, BigDecimal param2);
}
