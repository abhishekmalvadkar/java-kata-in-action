package com.amalvadkar.fbk;

import org.jspecify.annotations.NonNull;

public class FizzBuzzParser {

    public String parse(int number) {
        if (isDivisibleBy3And5(number)) return "FizzBuzz";
        if (isDivisibleBy3(number)) return "Fizz";
        if (isDivisibleBy5(number)) return "Buzz";
        return itSelfAsString(number);
    }

    private static @NonNull String itSelfAsString(int number) {
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
