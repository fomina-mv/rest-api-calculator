package com.fomina.error;

import org.springframework.web.bind.annotation.ResponseStatus;
@ResponseStatus
public class CalculatorBadRequestException extends RuntimeException {

    public CalculatorBadRequestException() {
        super("There are invalid characters in the parameters. Correct the request.");
    }

}
