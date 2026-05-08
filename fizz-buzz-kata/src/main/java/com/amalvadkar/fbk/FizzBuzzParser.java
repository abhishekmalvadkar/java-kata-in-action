package com.amalvadkar.fbk;

import java.util.stream.IntStream;

import static java.util.stream.Collectors.joining;

public class FizzBuzzParser {

    private static final String FIZZ = "Fizz";
    private static final String BUZZ = "Buzz";
    private static final String FIZZ_BUZZ = FIZZ + BUZZ;
    private static final String THREE = "3";
    private static final String FIVE = "5";
    private static final String NEW_LINE = "\n";
    private static final int START_FROM_ONE = 1;

    public String parse(int number) {
        StringBuilder builder = new StringBuilder();
        if (contains3(number)) builder.append(FIZZ);
        if (contains5(number)) builder.append(BUZZ);
        if (hasDivisibilityBy3Or5(number)) builder.append(parsedNumberIfDivisibleBy3or5(number));
        String parsedNumber = builder.toString();
        return doesNotMatchAnyCriteria(parsedNumber) ? asString(number) : parsedNumber;
    }

    public String parseTill(int tillNumber) {
        return parseRange(START_FROM_ONE, tillNumber);
    }

    public String parseRange(int fromNumber, int toNumber) {
        return IntStream.rangeClosed(fromNumber, toNumber)
                .boxed()
                .map(this::parse)
                .collect(joining(NEW_LINE));
    }

    private static boolean hasDivisibilityBy3Or5(int number) {
        return isDivisibleBy3(number) || isDivisibleBy5(number);
    }

    private static String parsedNumberIfDivisibleBy3or5(int number) {
        if (isDivisibleBy3And5(number)) return FIZZ_BUZZ;
        if (isDivisibleBy3(number)) return FIZZ;
        return BUZZ;
    }

    private static boolean doesNotMatchAnyCriteria(String parsedNumber) {
        return parsedNumber.isEmpty();
    }

    private static boolean contains3(int number) {
        return has(number, THREE);
    }

    private static boolean has(int number, String containsNumber) {
        return asString(number).contains(containsNumber);
    }

    private static boolean contains5(int number) {
        return has(number, FIVE);
    }

    private static String asString(int number) {
        return String.valueOf(number);
    }

    private static boolean isDivisibleBy3And5(int number) {
        return isDivisibleBy3(number) && isDivisibleBy5(number);
    }

    private static boolean isDivisibleBy5(int input) {
        return input % 5 == 0;
    }

    private static boolean isDivisibleBy3(int input) {
        return input % 3 == 0;
    }
}
