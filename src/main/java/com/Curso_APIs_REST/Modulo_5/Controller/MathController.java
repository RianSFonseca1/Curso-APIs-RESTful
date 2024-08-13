package com.Curso_APIs_REST.Modulo_5.Controller;

import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;


@RestController
@RequestMapping("/math")
public class MathController {

    @GetMapping("/operation/{number1}/{operator}/{number2}")
    public Double operation(@PathVariable String number1,@PathVariable String operator,@PathVariable String number2) throws Exception {
        if (!isNumeric(number1) || !isNumeric(number2)) {
            throw new UnsupportedOperationException("Please set a numeric value!");
        }
        switch (operator) {
            case "+":
                return convertToDouble(number1) + convertToDouble(number2);
            case "-":
                return convertToDouble(number1) - convertToDouble(number2);
            case "*":
                return convertToDouble(number1) * convertToDouble(number2);
            case "/":
                if (!number2.equals("0")) {
                    return convertToDouble(number1) / convertToDouble(number2);
                } else {
                    System.out.println("Erro: Divisão por zero.");
                }
            default:
                throw new UnsupportedOperationException("Please set a valid operator!");

        }
    }

    private boolean isNumeric (String strNumber){
        if(strNumber != null) {
            String number = strNumber.replaceAll(",",".");
            return number.matches("[-+]?[0-9]*\\.?[0-9]+");
        }else{
            return false;
        }
    }

    private Double convertToDouble (String strNumber) {
        String number = strNumber.replaceAll(",", ".");
        return Double.parseDouble(number);
    }
}
