package com.amalvadkar.fbk;

public record TillNumber(int value) {

    private static final int START_FROM_ONE = 1;

    public static TillNumber of(int value) {
        return new TillNumber(value);
    }

    public String parse() {
        return RangeNumber.of(START_FROM_ONE, value()).parse();
    }
}