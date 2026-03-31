package com.example.JUnit;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class DateFormatterTest {
	DateFormatter formatter = new DateFormatter();

    @Test
    void testValidDate() {
        assertEquals("25-12-2025", formatter.formatDate("2025-12-25"));
    }

    @Test
    void testAnotherValidDate() {
        assertEquals("01-01-2024", formatter.formatDate("2024-01-01"));
    }

    @Test
    void testInvalidFormat() {
        assertThrows(Exception.class, () -> {
            formatter.formatDate("12/25/2025");
        });
    }
    
    @Test
    void testNullDate() {
        assertThrows(IllegalArgumentException.class, () -> {
            formatter.formatDate(null);
        });
    }

    @Test
    void testEmptyDate() {
        assertThrows(IllegalArgumentException.class, () -> {
            formatter.formatDate("");
        });
    }
}
