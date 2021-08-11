package com.calculator;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals; 
/**
 * Unit test 
 */

public class StringCalculatorTest {
   
    @Test 
    @DisplayName("Test Empty String")
    public void testEmptyString() {
        assertEquals(0, StringCalculator.add(""));
    }

    @Test
    @DisplayName("Test One Number")
    public void testAddSingleNumber() {
        assertEquals(1, StringCalculator.add("1"));
        assertEquals(4, StringCalculator.add("4"));
    }

    @Test 
    @DisplayName("Test Two number")
    public void testAddWithTwoNumber() {
        assertEquals(3, StringCalculator.add("1,2"));
    }

    @Test
    @DisplayName("Test Multile Numbers")
    public void testAddMultipleNumber() {
        assertEquals(17, StringCalculator.add("4,3,6,4"));
    }

    @Test
    @DisplayName("Test New Line")
    public void testNewLineAsValidDelimiter() {
        assertEquals(10, StringCalculator.add("4\n2\n4"));
    }

    @Test
    @DisplayName("Test New Line And Comma")
    public void testNewLineAndComma() {
        assertEquals(14, StringCalculator.add("3\n4,7"));
    }

    @Test 
    @DisplayName("Test Custome Delimeter")
    public void testCustomDelimiter() {
        assertEquals(3, StringCalculator.add("//;\n1;2"));
    }

    @Test 
    @DisplayName("Test Negative Number")
    public void testNegativeNumber() {
        try {
            StringCalculator.add("-9");
            fail("Exception expected.");
            
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(), "Negative not allowed: -9");
        }
    }

    @Test 
    @DisplayName("Test multiple Negative Number")
    public void testMultipleNegativeNumber() {
        try {
            StringCalculator.add("1,-3,5,-5,-13");
            fail("Exception expected.");
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(), "Negative not allowed: -3,-5,-13");
        }
    }
}