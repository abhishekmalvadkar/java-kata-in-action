package com.amalvadkar.fbk;

import org.jspecify.annotations.NonNull;

public class FizzBuzzParser {

    public static final String FIZZ = "Fizz";
    public static final String BUZZ = "Buzz";
    public static final String FIZZ_BUZZ = FIZZ + BUZZ;

    public String parse(int number) {
        if (isDivisibleBy3And5(number)) return FIZZ_BUZZ;
        if (isDivisibleBy3(number)) return FIZZ;
        if (isDivisibleBy5(number)) return BUZZ;
        return itSelfAsString(number);
    }

    private static String itSelfAsString(int number) {
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
