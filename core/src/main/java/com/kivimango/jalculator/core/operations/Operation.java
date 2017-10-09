package com.kivimango.jalculator.core.operations;

import java.math.BigDecimal;

public interface Operation {
    String getOperator();
    BigDecimal calculate(BigDecimal param1, BigDecimal param2);
}
