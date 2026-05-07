package com.amalvadkar.fbk;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FizzBuzzParserParseTillTest extends AbstractFizzBuzzTest {

    @Test
    void should_return_parsed_result_till_5() {
        assertThat(fizzBuzzParser.parseTill(5)).isEqualTo("""
                1
                2
                FizzFizz
                4
                BuzzBuzz""");
    }

}
