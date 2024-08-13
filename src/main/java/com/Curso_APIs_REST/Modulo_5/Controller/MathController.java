package com.Curso_APIs_REST.Modulo_5.Controller;

import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;


@RestController
@RequestMapping("/math")
public class MathController {

    @GetMapping("/operation/{operator}/{number1}/{number2}")
    public Double operation(@PathVariable String operator,@PathVariable String number1,@PathVariable String number2) throws Exception {
        if (!isNumeric(number1) || !isNumeric(number2)) {
            throw new UnsupportedOperationException("Please set a numeric value!");
        }
        switch (operator) {
            case "sum":
                return convertToDouble(number1) + convertToDouble(number2);
            case "subtraction":
                return convertToDouble(number1) - convertToDouble(number2);
            case "multiplication":
                return convertToDouble(number1) * convertToDouble(number2);
            case "division":
                if (!number2.equals("0")) {
                    return convertToDouble(number1) / convertToDouble(number2);
                } else {
                    System.out.println("Erro: Divisão por zero.");
                }
            case "mean":
                return (convertToDouble(number1) + convertToDouble(number2))/2;
            default:
                throw new UnsupportedOperationException("Please set a valid operator!");
        }
    }

    @GetMapping("/squareRoot/{number}")
    public Double operationSquareRoot(@PathVariable String number) throws Exception {
        if (!isNumeric(number)) {
            throw new UnsupportedOperationException("Please set a numeric value!");
        }

        return Math.sqrt(convertToDouble(number));
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
