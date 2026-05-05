package com.amalvadkar.fbk;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FizzBuzzParserTest {

    FizzBuzzParser fizzBuzzParser;

    @BeforeEach
    void setUp() {
        fizzBuzzParser = new FizzBuzzParser();
    }

    @Test
    void should_return_1_when_passed_input_as_1() {
        assertThat(fizzBuzzParser.parse(1)).isEqualTo("1");
    }

    @Test
    void should_return_2_when_passed_input_as_2() {
        assertThat(fizzBuzzParser.parse(2)).isEqualTo("2");
    }

    @Test
    void should_return_4_when_passed_input_as_4() {
        assertThat(fizzBuzzParser.parse(4)).isEqualTo("4");
    }

    @Test
    void should_return_Fizz_when_passed_input_as_3() {
        assertThat(fizzBuzzParser.parse(3)).isEqualTo("Fizz");
    }

    @Test
    void should_return_Fizz_when_passed_input_as_6() {
        assertThat(fizzBuzzParser.parse(6)).isEqualTo("Fizz");
    }
}
