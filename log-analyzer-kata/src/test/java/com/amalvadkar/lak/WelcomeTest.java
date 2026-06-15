package com.amalvadkar.lak;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WelcomeTest {
    @Test
    void should_welcome() {
        String welcomeText = "Welcome to log analyzer kata";
        assertThat(welcomeText).isEqualTo("Welcome to log analyzer kata");
    }
}
