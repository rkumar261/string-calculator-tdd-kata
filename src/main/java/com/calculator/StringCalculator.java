package com.calculator;

import java.util.Arrays;
import java.util.stream.Stream;

public class StringCalculator {
    public static int add(String numbers) {
        if(numbers.isEmpty()) {
            return 0;
        } 
        
        Stream<String> num = Arrays.stream(numbers.split(",|\n"));
        return num.mapToInt(Integer::parseInt).sum();
    }

} 