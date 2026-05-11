package com.amalvadkar.fbk;

import java.util.stream.IntStream;

import static java.util.stream.Collectors.joining;

public record RangeNumber(int fromNumber, int toNumber) {

    private static final String NEW_LINE = "\n";

    public static RangeNumber of(int fromNumber, int toNumber) {
        return new RangeNumber(fromNumber, toNumber);
    }

    public String parse() {
        return IntStream.rangeClosed(fromNumber(), toNumber())
                .boxed()
                .map(this::parse)
                .collect(joining(NEW_LINE));
    }

    private String parse(Integer number) {
        return FizzBuzzNumber.of(number).parse();
    }
}