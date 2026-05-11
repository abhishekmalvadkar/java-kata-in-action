package com.amalvadkar.fbk;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FizzBuzzTillNumberTest extends AbstractFizzBuzzTest {

    @Test
    void should_return_parsed_result_till_5() {
        assertThat(TillNumber.of(5).parse()).isEqualTo("""
                1
                2
                FizzFizz
                4
                BuzzBuzz""");
    }

    @Test
    void should_return_parsed_result_till_15() {
        assertThat(TillNumber.of(15).parse()).isEqualTo("""
            1
            2
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
