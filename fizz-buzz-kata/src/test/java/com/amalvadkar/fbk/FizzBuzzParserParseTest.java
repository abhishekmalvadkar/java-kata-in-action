package com.amalvadkar.fbk;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FizzBuzzParserParseTest extends AbstractFizzBuzzTest {

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
    void should_return_FizzFizz_when_passed_input_as_3_because_it_contains_3_and_divisible_by_3() {
        assertThat(fizzBuzzParser.parse(3)).isEqualTo("FizzFizz");
    }

    @Test
    void should_return_Fizz_when_passed_input_as_6() {
        assertThat(fizzBuzzParser.parse(6)).isEqualTo("Fizz");
    }

    @Test
    void should_return_Fizz_when_passed_input_as_9() {
        assertThat(fizzBuzzParser.parse(9)).isEqualTo("Fizz");
    }

    @Test
    void should_return_BuzzBuzz_when_passed_input_as_5_because_it_contains_5_and_divisible_by_5() {
        assertThat(fizzBuzzParser.parse(5)).isEqualTo("BuzzBuzz");
    }

    @Test
    void should_return_Buzz_when_passed_input_as_10() {
        assertThat(fizzBuzzParser.parse(10)).isEqualTo("Buzz");
    }

    @Test
    void should_return_Fizz_when_passed_input_as_13_because_it_contains_3() {
        assertThat(fizzBuzzParser.parse(13)).isEqualTo("Fizz");
    }

    @Test
    void should_return_BuzzFizzBuzz_when_passed_input_as_15_because_it_contains_5_and_divisible_by_3_and_5_both() {
        assertThat(fizzBuzzParser.parse(15)).isEqualTo("BuzzFizzBuzz");
    }

    @Test
    void should_return_FizzBuzz_when_passed_input_as_53_because_it_contains_3_and_contains_5() {
        assertThat(fizzBuzzParser.parse(53)).isEqualTo("FizzBuzz");
    }

    @Test
    void should_return_FizzBuzzBuzz_when_passed_input_as_35_because_it_contains_3_and_contains_5_and_divisible_by_5() {
        assertThat(fizzBuzzParser.parse(35)).isEqualTo("FizzBuzzBuzz");
    }
}
