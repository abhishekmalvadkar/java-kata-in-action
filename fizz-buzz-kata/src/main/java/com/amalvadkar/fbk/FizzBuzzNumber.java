package com.amalvadkar.fbk;

public record FizzBuzzNumber(int value) {
    private static final String THREE = "3";
    private static final String FIVE = "5";
    private static final String FIZZ = "Fizz";
    private static final String BUZZ = "Buzz";
    private static final String FIZZ_BUZZ = FIZZ + BUZZ;

    public static FizzBuzzNumber of(int value) {
        return new FizzBuzzNumber(value);
    }

    public String parse() {
        StringBuilder builder = new StringBuilder();
        if (contains3()) builder.append(FIZZ);
        if (contains5()) builder.append(BUZZ);
        if (hasDivisibilityBy3Or5()) builder.append(parsedNumberIfDivisibleBy3or5());
        String parsedNumber = builder.toString();
        return doesNotMatchAnyCriteria(parsedNumber) ? asString() : parsedNumber;
    }

    private String asString() {
        return String.valueOf(value());
    }

    private boolean has(String containsNumber) {
        return asString().contains(containsNumber);
    }

    private boolean contains3() {
        return has(THREE);
    }

    private boolean contains5() {
        return has(FIVE);
    }

    private boolean isDivisibleBy3() {
        return value() % 3 == 0;
    }

    private boolean isDivisibleBy5() {
        return value() % 5 == 0;
    }

    private boolean isDivisibleBy3And5() {
        return isDivisibleBy3() && isDivisibleBy5();
    }

    private boolean hasDivisibilityBy3Or5() {
        return isDivisibleBy3() || isDivisibleBy5();
    }

    private String parsedNumberIfDivisibleBy3or5() {
        if (isDivisibleBy3And5()) return FIZZ_BUZZ;
        if (isDivisibleBy3()) return FIZZ;
        return BUZZ;
    }

    private boolean doesNotMatchAnyCriteria(String parsedNumber) {
        return parsedNumber.isEmpty();
    }
}