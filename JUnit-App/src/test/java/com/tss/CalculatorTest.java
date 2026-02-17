package com.tss;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorTest {

    Calculator calculator;

    @BeforeEach
    void setup() {
        calculator = new Calculator();
    }

    @Test
    @DisplayName("Should return correct sum for two positive numbers")
    void addition() {
        double result = calculator.addition(3, 2);
        assertEquals(5, result, "Should perform addition");
    }

    @Test
    void subtraction () {
        double result = calculator.subtraction (8, 5);
        assertEquals(3, result);
    }

    @Test
    void multiplication() {
        double result = calculator.multiplication(5,2);
        assertEquals(10, result);
    }

    @Test
    void divide() {
        double result = calculator.division(6,2);
        assertEquals(3, result);
    }
}