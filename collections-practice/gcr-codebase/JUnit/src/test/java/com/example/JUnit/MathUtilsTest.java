package com.example.JUnit;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class MathUtilsTest {
	MathUtils math = new MathUtils();

    @Test
    void testDivideByZeroException() {
        assertThrows(ArithmeticException.class, () -> {
            math.divide(10, 0);
        });
    }
}
