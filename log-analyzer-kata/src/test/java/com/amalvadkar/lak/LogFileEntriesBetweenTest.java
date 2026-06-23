package com.amalvadkar.lak;

import com.amalvadkar.lak.domain.LogFile;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

public class LogFileEntriesBetweenTest extends AbstractLogAnalyzerTest {
    @Test
    void should_return_entries_between_give_time_range() {
        String logEntries = """
                2026-07-10T10:00:00 INFO : User login
                2026-07-10T10:15:30 WARN : High memory usage
                2026-07-10T10:45:12 ERROR : Payment failed
                2026-07-10T11:05:10 INFO : User logout
                2026-07-10T11:20:05 ERROR : Database unavailable
                """;
        LogFile logFile = LogFile.from(logEntries);

        LocalDateTime from = LocalDateTime.of(2026, 7, 10, 10, 10);
        LocalDateTime to = LocalDateTime.of(2026, 7, 10, 11, 10);
        assertThat(logFile.entriesBetween(from, to)).isEqualTo("""
                2026-07-10T10:15:30 WARN : High memory usage
                2026-07-10T10:45:12 ERROR : Payment failed
                2026-07-10T11:05:10 INFO : User logout""");
    }

    @Test
    void should_return_empty_string_when_not_entries_exists_for_asked_date_time_range() {
        String logEntries = """
                2026-07-10T10:00:00 INFO : User login
                2026-07-10T10:15:30 WARN : High memory usage
                """;
        LogFile logFile = LogFile.from(logEntries);

        LocalDateTime from = LocalDateTime.of(2026, 7, 10, 11, 0);
        LocalDateTime to = LocalDateTime.of(2026, 7, 10, 12, 0);
        assertThat(logFile.entriesBetween(from, to)).isEmpty();
    }

    @Test
    void should_return_empty_string_when_entries_asked_with_date_time_range_on_empty_log_file() {
        String logEntries = "";
        LogFile logFile = LogFile.from(logEntries);

        LocalDateTime from = LocalDateTime.of(2026, 7, 10, 11, 0);
        LocalDateTime to = LocalDateTime.of(2026, 7, 10, 12, 0);
        assertThat(logFile.entriesBetween(from, to)).isEmpty();
    }

    @Test
    void should_return_with_inclusive_from_timestamp_entries_between_give_time_range() {
        String logEntries = """
                2026-07-10T10:00:00 INFO : User login
                2026-07-10T10:15:30 WARN : High memory usage
                """;
        LogFile logFile = LogFile.from(logEntries);

        LocalDateTime from = LocalDateTime.of(2026, 7, 10, 10, 0, 0);
        LocalDateTime to = LocalDateTime.of(2026, 7, 10, 10, 10, 0);
        assertThat(logFile.entriesBetween(from, to)).isEqualTo("2026-07-10T10:00 INFO : User login");
    }

    @Test
    void should_return_with_inclusive_to_timestamp_entries_between_give_time_range() {
        String logEntries = """
                2026-07-10T10:15:30 WARN : High memory usage
                2026-07-10T10:30:00 INFO : User logout
                """;
        LogFile logFile = LogFile.from(logEntries);

        LocalDateTime from = LocalDateTime.of(2026, 7, 10, 10, 20, 0);
        LocalDateTime to = LocalDateTime.of(2026, 7, 10, 10, 30, 0);
        assertThat(logFile.entriesBetween(from, to)).isEqualTo("2026-07-10T10:30 INFO : User logout");
    }

    @Test
    void should_return_with_inclusive_from_and_to_timestamp_entries_between_give_time_range() {
        String logEntries = """
                2026-07-10T10:00:00 INFO : User login
                2026-07-10T10:15:30 WARN : High memory usage
                2026-07-10T10:30:00 ERROR : Payment failed
                """;
        LogFile logFile = LogFile.from(logEntries);

        LocalDateTime from = LocalDateTime.of(2026, 7, 10, 10, 0, 0);
        LocalDateTime to = LocalDateTime.of(2026, 7, 10, 10, 30, 0);
        assertThat(logFile.entriesBetween(from, to)).isEqualTo("""
                2026-07-10T10:00 INFO : User login
                2026-07-10T10:15:30 WARN : High memory usage
                2026-07-10T10:30 ERROR : Payment failed""");
    }
}
