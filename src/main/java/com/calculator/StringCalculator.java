package com.calculator;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;



public class StringCalculator {

    private String delimiter;
    private String numbers;

    private StringCalculator(String delimiter, String numbers) {
        this.delimiter = delimiter;
        this.numbers = numbers;
    }

    private IntStream getNumbers() {
        if(numbers.isEmpty()) {
            return IntStream.empty();
        } else {
            return Stream.of(numbers.split(delimiter)).mapToInt(Integer::parseInt);
        }
    }

	private void ensureNoNegativeNumbers() {
		String negativeNumbers = getNumbers().filter(n -> n < 0)
				.mapToObj(Integer::toString)
				.collect(Collectors.joining(","));
		if (!negativeNumbers.isEmpty()) {
			throw new IllegalArgumentException("Negative not allowed: " + negativeNumbers);
		}
	}

    private int sum() {
        ensureNoNegativeNumbers();
        return getNumbers().sum();
    }

    private static StringCalculator parseInput(String input) {
        if(input.startsWith("//")) {
            //input string will be divied into two parts
            String[] parts = input.split("\n", 2);
            return new StringCalculator(parts[0].substring(2), parts[1]);
        } else {
            return new StringCalculator(",|\n", input);
        }
    }

    public static int add(String input) {
        if(input.isEmpty()) {
            return 0;
        } 

        StringCalculator calculator = parseInput(input);
        return calculator.sum();
    }
} 