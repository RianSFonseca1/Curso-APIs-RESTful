package com.Curso_APIs_REST.Modulo_5.Controller;

import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;


@RestController
@RequestMapping("/math")
public class MathController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/sum/{number1}/{number2}")
    public Double sum(@PathVariable String number1, @PathVariable String number2) throws Exception{
        if(!isNumeric(number1) || !isNumeric(number2)){
            throw new Exception("Algum dos valores inseridos não é numérico!");
        }
        return convertToDouble(number1) + convertToDouble(number2);
    }

    private boolean isNumeric (String strNumber){
        if(strNumber != null) {
            String number = strNumber.replaceAll(",",".");
            return number.matches("[-+]?[0-9]*\\.?[0-9]+");
        }else{
            return false;
        }
    }

    private Double convertToDouble (String strNumber){
        if(strNumber != null) {
            if (isNumeric(strNumber)) {
                String number = strNumber.replaceAll(",",".");
                return Double.parseDouble(number);
            }else{
                return 0D;
            }
        }
        return 0D;
    }
}
