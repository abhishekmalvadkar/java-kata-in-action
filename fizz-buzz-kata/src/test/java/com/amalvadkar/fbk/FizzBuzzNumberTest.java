package com.amalvadkar.fbk;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FizzBuzzNumberTest extends AbstractFizzBuzzTest {

    @Test
    void should_return_1_when_passed_input_as_1() {
        assertThat(FizzBuzzNumber.of(1).parse()).isEqualTo("1");
    }

    @Test
    void should_return_2_when_passed_input_as_2() {
        assertThat(FizzBuzzNumber.of(2).parse()).isEqualTo("2");
    }

    @Test
    void should_return_4_when_passed_input_as_4() {
        assertThat(FizzBuzzNumber.of(4).parse()).isEqualTo("4");
    }

    @Test
    void should_return_FizzFizz_when_passed_input_as_3_because_it_contains_3_and_divisible_by_3() {
        assertThat(FizzBuzzNumber.of(3).parse()).isEqualTo("FizzFizz");
    }

    @Test
    void should_return_Fizz_when_passed_input_as_6() {
        assertThat(FizzBuzzNumber.of(6).parse()).isEqualTo("Fizz");
    }

    @Test
    void should_return_Fizz_when_passed_input_as_9() {
        assertThat(FizzBuzzNumber.of(9).parse()).isEqualTo("Fizz");
    }

    @Test
    void should_return_BuzzBuzz_when_passed_input_as_5_because_it_contains_5_and_divisible_by_5() {
        assertThat(FizzBuzzNumber.of(5).parse()).isEqualTo("BuzzBuzz");
    }

    @Test
    void should_return_Buzz_when_passed_input_as_10() {
        assertThat(FizzBuzzNumber.of(10).parse()).isEqualTo("Buzz");
    }

    @Test
    void should_return_Fizz_when_passed_input_as_13_because_it_contains_3() {
        assertThat(FizzBuzzNumber.of(13).parse()).isEqualTo("Fizz");
    }

    @Test
    void should_return_BuzzFizzBuzz_when_passed_input_as_15_because_it_contains_5_and_divisible_by_3_and_5_both() {
        assertThat(FizzBuzzNumber.of(15).parse()).isEqualTo("BuzzFizzBuzz");
    }

    @Test
    void should_return_FizzBuzz_when_passed_input_as_53_because_it_contains_3_and_contains_5() {
        assertThat(FizzBuzzNumber.of(53).parse()).isEqualTo("FizzBuzz");
    }

    @Test
    void should_return_FizzBuzzBuzz_when_passed_input_as_35_because_it_contains_3_and_contains_5_and_divisible_by_5() {
        assertThat(FizzBuzzNumber.of(35).parse()).isEqualTo("FizzBuzzBuzz");
    }
}
