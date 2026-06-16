package com.amalvadkar.lak;

import com.amalvadkar.lak.domain.LogEntry;
import com.amalvadkar.lak.enums.LogLevel;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LogEntryTest extends AbstractLogAnalyzerTest {
    @Test
    void should_parse_single_log_entry_with_single_word_log_message() {
        LogEntry logEntry = LogEntry.parse("2026-07-10T10:00:00 INFO : login");

        assertThat(logEntry.getTimestamp()).isEqualTo("2026-07-10T10:00:00");
        assertThat(logEntry.getLogLevel()).isEqualTo(LogLevel.INFO);
        assertThat(logEntry.getMessage()).isEqualTo("login");
    }

    @Test
    void should_parse_single_log_entry_with_multi_word_log_message() {
        LogEntry logEntry = LogEntry.parse("2026-07-10T10:00:00 INFO : User login");

        assertThat(logEntry.getTimestamp()).isEqualTo("2026-07-10T10:00:00");
        assertThat(logEntry.getLogLevel()).isEqualTo(LogLevel.INFO);
        assertThat(logEntry.getMessage()).isEqualTo("User login");
    }

    @Test
    void should_parse_single_log_entry_with_more_spaces_in_the_middle() {
        LogEntry logEntry = LogEntry.parse("2026-07-10T10:00:00        INFO     :      User login");

        assertThat(logEntry.getTimestamp()).isEqualTo("2026-07-10T10:00:00");
        assertThat(logEntry.getLogLevel()).isEqualTo(LogLevel.INFO);
        assertThat(logEntry.getMessage()).isEqualTo("User login");
    }

    @Test
    void should_parse_single_log_entry_with_more_leading_and_trailing_spaces() {
        LogEntry logEntry = LogEntry.parse("               2026-07-10T10:00:00        INFO     :      User login              ");

        assertThat(logEntry.getTimestamp()).isEqualTo("2026-07-10T10:00:00");
        assertThat(logEntry.getLogLevel()).isEqualTo(LogLevel.INFO);
        assertThat(logEntry.getMessage()).isEqualTo("User login");
    }
}
