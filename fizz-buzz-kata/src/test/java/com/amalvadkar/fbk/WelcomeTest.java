package com.amalvadkar.fbk;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WelcomeTest {
    @Test
    void should_welcome() {
        String welcomeText = "welcome";
        assertThat(welcomeText).isEqualTo("welcome");
    }
}
