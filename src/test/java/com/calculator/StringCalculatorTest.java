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
}