package com.Curso_APIs_REST.Modulo_5.Controller;

import com.Curso_APIs_REST.Modulo_5.Services.CalculatorServiceImpl;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;


@RestController
@RequestMapping("/math")
public class MathController {

    private final CalculatorServiceImpl calculator;

    public MathController(CalculatorServiceImpl calculator) {
        this.calculator = calculator;
    }

    @GetMapping("/sum/{number1}/{number2}")
    public Double sum(@PathVariable String number1,@PathVariable String number2){
        return calculator.sum(number1,number2);
    }

    @GetMapping("/subtraction/{number1}/{number2}")
    public Double subtraction(@PathVariable String number1,@PathVariable String number2){
        return calculator.subtraction(number1,number2);
    }

    @GetMapping("/multiplication/{number1}/{number2}")
    public Double multiplication(@PathVariable String number1,@PathVariable String number2){
        return calculator.multiplication(number1,number2);
    }

    @GetMapping("/division/{number1}/{number2}")
    public Double division(@PathVariable String number1,@PathVariable String number2){
        return calculator.division(number1,number2);
    }

    @GetMapping("/mean/{number1}/{number2}")
    public Double mean(@PathVariable String number1,@PathVariable String number2){
        return calculator.mean(number1,number2);
    }

    @GetMapping("/mean/{number1}")
    public Double mean(@PathVariable String number1){
        return calculator.mean(number1);
    }

    @GetMapping("/squareRoot/{number1}")
    public Double squareRoot(@PathVariable String number1){
        return calculator.squareRoot(number1);
    }

}
