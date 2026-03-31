package com.example.JUnit;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class StringUtilsTest {
	StringUtils utils = new StringUtils();

    @Test
    void testReverse() {
        assertEquals("olleh", utils.reverse("hello"));
    }

    @Test
    void testPalindromeTrue() {
        assertTrue(utils.isPalindrome("madam"));
    }

    @Test
    void testPalindromeFalse() {
        assertFalse(utils.isPalindrome("hello"));
    }
    
    @Test
    void testUpperCase() {
        assertEquals("HELLO", utils.toUpperCase("hello"));
    }

    @Test
    void testReverseNull() {
        assertNull(utils.reverse(null));
    }

    @Test
    void testPalindromeNull() {
        assertFalse(utils.isPalindrome(null));
    }
    
    @Test
    void testUpperCaseNull() {
        assertNull(utils.toUpperCase(null));
    }
}
