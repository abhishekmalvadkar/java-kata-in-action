package com.amalvadkar.fbk;

public class FizzBuzzParser {

    public String parse(int input) {
        if (input % 3 == 0) return "Fizz";
        return String.valueOf(input);
    }
}
