package com.example.JUnit;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

public class PerformanceUtilsTest {
	PerformanceUtils utils = new PerformanceUtils();

    @Test
    @Timeout(2) // Fails if execution exceeds 2 seconds
    void testLongRunningTask() throws InterruptedException {
        String result = utils.longRunningTask();
        assertEquals("Task Completed", result);
    }
}
