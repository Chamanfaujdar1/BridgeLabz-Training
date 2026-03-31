package com.example.JUnit;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    Calculator calc = new Calculator();

    @Test
    void addTest() {
        assertEquals(15, calc.add(10, 5));
    }

    @Test
    void subtractTest() {
        assertEquals(5, calc.subtract(10, 5));
    }

    @Test
    void multiplyTest() {
        assertEquals(50, calc.multiply(10, 5));
    }

    @Test
    void divideTest() {
        assertEquals(2.0, calc.divide(10, 5));
    }

    @Test
    void divideByZeroTest() {
        assertThrows(ArithmeticException.class, () -> {
            calc.divide(10, 0);
        });
    }
}
