package com.amalvadkar.fbk;

public class FizzBuzzParser {

    private static final String FIZZ = "Fizz";
    private static final String BUZZ = "Buzz";
    private static final String FIZZ_BUZZ = FIZZ + BUZZ;

    public String parse(int number) {
        if (contains3(number)) return FIZZ;
        if (isDivisibleBy3And5(number)) return FIZZ_BUZZ;
        if (isDivisibleBy3(number)) return FIZZ;
        if (isDivisibleBy5(number)) return BUZZ;
        return asString(number);
    }

    private static boolean contains3(int number) {
        return asString(number).contains("3");
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
