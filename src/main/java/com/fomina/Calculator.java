package com.fomina;

import com.fomina.error.CalculatorBadRequestException;

public class Calculator {
    Float firstParam;
    String sign;
    Float secondParam;
    public Calculator(Float firstParam, String sign, Float secondParam) {
        this.firstParam = firstParam;
        this.sign = sign;
        this.secondParam = secondParam;
    }

    public Float getResult() {
            if (sign.equals("/") && secondParam != 0) {
                return firstParam / secondParam;
            } else if (sign.equals("*")) {
                return firstParam * secondParam;
            } else if (sign.equals("-")) {
                return firstParam - secondParam;
            } else if (sign.equals("%2b") || sign.equals("+")) {
                return firstParam + secondParam;
            } else {
                throw new CalculatorBadRequestException();
            }
    }

}
