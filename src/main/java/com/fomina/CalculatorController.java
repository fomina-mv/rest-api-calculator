package com.fomina;

import com.fomina.error.CalculatorBadRequestException;
import org.springframework.web.bind.annotation.*;

@RestController
public class CalculatorController {

    @GetMapping("/calculate")
    Calculator newCalculator(@RequestParam(value = "firstParam") Float firstParam,
                       @RequestParam(value = "sign") String sign,
                       @RequestParam(value = "secondParam") Float secondParam) {
        Calculator calc = new Calculator(firstParam, sign, secondParam);
        if (calc.getResult()!=null) {
            return calc;
        } else {
            throw new CalculatorBadRequestException();
        }
    }

}



