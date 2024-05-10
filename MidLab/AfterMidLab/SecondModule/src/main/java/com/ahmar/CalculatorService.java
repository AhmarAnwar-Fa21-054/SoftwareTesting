package com.ahmar;

public class CalculatorService {
    private Calculator calculator;

    public CalculatorService(Calculator calculator) {
        this.calculator = calculator;

    }

    public Integer performAddition(int a, int b) { //a :2 ,b:3
//        a = 7;
//        b = 8;

        return calculator.add(4, 9);  // 5
    }
}
