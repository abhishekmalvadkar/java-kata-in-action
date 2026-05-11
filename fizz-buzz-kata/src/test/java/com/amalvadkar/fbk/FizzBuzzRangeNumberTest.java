package com.amalvadkar.fbk;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FizzBuzzRangeNumberTest extends AbstractFizzBuzzTest {

    @Test
    void should_return_parsed_result_from_2_to_5() {
        assertThat(RangeNumber.of(2, 5).parse()).isEqualTo("""
                2
                FizzFizz
                4
                BuzzBuzz""");
    }

    @Test
    void should_return_parsed_result_from_3_to_15() {
        assertThat(RangeNumber.of(3, 15).parse()).isEqualTo("""
            FizzFizz
            4
            BuzzBuzz
            Fizz
            7
            8
            Fizz
            Buzz
            11
            Fizz
            Fizz
            14
            BuzzFizzBuzz""");
    }

}
