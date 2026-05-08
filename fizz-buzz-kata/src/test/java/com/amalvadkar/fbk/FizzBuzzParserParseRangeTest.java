package com.amalvadkar.fbk;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FizzBuzzParserParseRangeTest extends AbstractFizzBuzzTest {

    @Test
    void should_return_parsed_result_from_2_to_5() {
        assertThat(fizzBuzzParser.parseRange(2,5)).isEqualTo("""
                2
                FizzFizz
                4
                BuzzBuzz""");
    }

}
