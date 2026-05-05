package com.amalvadkar.fbk;

public class FizzBuzzParser {

    public String parse(int input) {
        if (input % 3 == 0) return "Fizz";
        if (input % 5 == 0) return "Buzz";
        return String.valueOf(input);
    }
}
