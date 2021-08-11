package com.calculator;

import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StringCalculator {

	public static int count = 0;
	private String delimiter;
	private String numbers;
    
    public StringCalculator() {

	}
    
	private StringCalculator(String delimiter, String numbers) {
		this.delimiter = delimiter;
		this.numbers = numbers;
	}

	private IntStream getNumbers() {
		if (numbers.isEmpty()) {
			return IntStream.empty();
		} else {
			return Stream.of(numbers.split(delimiter))
                    .mapToInt(Integer::parseInt)
					.filter(n -> n <= 1000);
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
		synchronized(this) {
			count++;
		}
		
		ensureNoNegativeNumbers();
		return getNumbers().sum();
	}

    private static String parseDelimiter(String header) {
		String delimiter = header.substring(2);
		if (delimiter.startsWith("[")) {
			delimiter = delimiter.substring(1, delimiter.length() - 1);
		}

        return Pattern.quote(delimiter);
	}

	private static StringCalculator parseInput(String input) {
		if (input.startsWith("//")) {
			String[] headerAndNumbers = input.split("\n", 2);
			String delimiter = parseDelimiter(headerAndNumbers[0]);
			return new StringCalculator(delimiter, headerAndNumbers[1]);
		} else {
			return new StringCalculator(",|\n", input);
		}
	}
    
	public static int add(String input) {
		return parseInput(input).sum();
	}

	public static int getCalledCount() {
		return count;
	}
}