package com.tss;

public class Calculator {

    public double addition(double num1, double num2) {
        return num1 + num2;
    }

    public double subtraction (double num1, double num2) {
        return num1 - num2;
    }

    public double multiplication(double num1, double num2) {
        if (num2 == 0) {
            throw new IllegalArgumentException("Cannot divide by zero");
        }
        return num1 * num2;
    }

    public double division(double num1, double num2) {
        return num1 / num2;
    }
}
