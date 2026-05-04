package com.amalvadkar.fbk;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FizzBuzzParserTest {

    @Test
    void should_return_1_when_passed_input_as_1() {
        FizzBuzzParser fizzBuzzParser = new FizzBuzzParser();
        assertThat(fizzBuzzParser.parse(1)).isEqualTo("1");
    }

    @Test
    void should_return_2_when_passed_input_as_1() {
        FizzBuzzParser fizzBuzzParser = new FizzBuzzParser();
        assertThat(fizzBuzzParser.parse(2)).isEqualTo("2");
    }

    @Test
    void should_return_4_when_passed_input_as_4() {
        FizzBuzzParser fizzBuzzParser = new FizzBuzzParser();
        assertThat(fizzBuzzParser.parse(4)).isEqualTo("4");
    }
}
