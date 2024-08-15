package com.Curso_APIs_REST.Modulo_5.Services;

public interface CalculatorService {

    Double sum(String strNumber1, String strNumber2);

    Double subtraction(String strNumber1, String strNumber2);

    Double multiplication(String strNumber1, String strNumber2);

    Double division(String strNumber1, String strNumber2);

    Double mean(String strNumber1, String strNumber2);

    Double mean(String strNumber);

    Double squareRoot(String strNumber1);

}
