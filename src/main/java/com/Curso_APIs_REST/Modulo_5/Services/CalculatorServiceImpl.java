package com.Curso_APIs_REST.Modulo_5.Services;

import org.springframework.stereotype.Service;

@Service
public class CalculatorServiceImpl implements CalculatorService{
    @Override
    public Double sum(String strNumber1, String strNumber2) {
        if (!isNumeric(strNumber1) || !isNumeric(strNumber2)) {
            throw new UnsupportedOperationException("PLEASE SET A NUMERIC VALUE!");
        }
        return convertToDouble(strNumber1) + convertToDouble(strNumber2);    }

    @Override
    public Double subtraction(String strNumber1, String strNumber2) {
        if (!isNumeric(strNumber1) || !isNumeric(strNumber2)) {
            throw new UnsupportedOperationException("PLEASE SET A NUMERIC VALUE!");
        }
        return convertToDouble(strNumber1) - convertToDouble(strNumber2);
    }

    @Override
    public Double multiplication(String strNumber1, String strNumber2) {
        if (!isNumeric(strNumber1) || !isNumeric(strNumber2)) {
            throw new UnsupportedOperationException("PLEASE SET A NUMERIC VALUE!");
        }
        return convertToDouble(strNumber1) * convertToDouble(strNumber2);
    }

    @Override
    public Double division(String strNumber1, String strNumber2) {
        if (!strNumber2.equals("0")) {
            if (!isNumeric(strNumber1) || !isNumeric(strNumber2)) {
                throw new UnsupportedOperationException("PLEASE SET A NUMERIC VALUE!");
            }
            return convertToDouble(strNumber1) / convertToDouble(strNumber2);
        } else {
            throw new UnsupportedOperationException("ERROR: DIVISION BY ZERO");
        }
    }

    @Override
    public Double mean(String strNumber1, String strNumber2) {
        if (!isNumeric(strNumber1) || !isNumeric(strNumber2)) {
            throw new UnsupportedOperationException("PLEASE SET A NUMERIC VALUE!");
        }
        return (convertToDouble(strNumber1) + convertToDouble(strNumber2))/2;
    }

    @Override
    public Double mean(String strNumber) {
        if (!isNumeric(strNumber)) {
            throw new UnsupportedOperationException("PLEASE SET A NUMERIC VALUE!");
        }
        return convertToDouble(strNumber)/2;
    }

    @Override
    public Double squareRoot(String strNumber) {
        if (!isNumeric(strNumber)) {
            throw new UnsupportedOperationException("PLEASE SET A NUMERIC VALUE!");
        }
        return Math.sqrt(convertToDouble(strNumber));
    }

    private Double convertToDouble(String strNumber) {
        String number = strNumber.replaceAll(",", ".");
        return Double.parseDouble(number);
    }

    private boolean isNumeric (String strNumber){
        if(strNumber != null) {
            String number = strNumber.replaceAll(",",".");
            return number.matches("[-+]?[0-9]*\\.?[0-9]+");
        }else{
            return false;
        }
    }
}
