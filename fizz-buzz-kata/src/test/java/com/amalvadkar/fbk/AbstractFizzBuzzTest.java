package com.amalvadkar.fbk;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;

@Tag("fizz-buzz")
public class AbstractFizzBuzzTest {

    protected FizzBuzzParser fizzBuzzParser;

    @BeforeEach
    void setUp() {
        fizzBuzzParser = new FizzBuzzParser();
    }

}
