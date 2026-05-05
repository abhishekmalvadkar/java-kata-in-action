package com.amalvadkar.fbk;

public class FizzBuzzParser {

    public String parse(int input) {
        if (input % 5 == 0) return "Buzz";
        if (input % 3 == 0) return "Fizz";
        return String.valueOf(input);
    }
}
