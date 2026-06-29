package com.amalvadkar.lak;

import com.amalvadkar.lak.domain.LogFile;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class LogFileFindBusyHourSummaryTest extends AbstractLogAnalyzerTest {
    @Test
    void should_return_busy_hour_summary() {
        String logEntries = """
                2026-07-10T10:00:00 INFO : User login
                2026-07-10T10:15:30 WARN : High memory usage
                2026-07-10T10:45:12 ERROR : Payment failed
                2026-07-10T11:05:10 INFO : User logout
                2026-07-10T11:20:05 ERROR : Database unavailable
                """;
        LogFile logFile = LogFile.from(logEntries);

        Optional<BusyHourSummary> busyHourSummary = logFile.findBusyHourSummary();
        assertThat(busyHourSummary).isNotEmpty();
        assertThat(busyHourSummary.get()).isEqualTo(
                new BusyHourSummary("2026-07-10T10", 3L)
        );
    }

    @Test
    void should_return_busy_hour_when_entries_has_same_hour() {
        String logEntries = """
                2026-07-10T10:00:00 INFO : User login
                2026-07-10T10:30:00 INFO : User logout
                """;
        LogFile logFile = LogFile.from(logEntries);

        Optional<BusyHourSummary> busyHourSummary = logFile.findBusyHourSummary();
        assertThat(busyHourSummary).isNotEmpty();
        assertThat(busyHourSummary.get()).isEqualTo(
                new BusyHourSummary("2026-07-10T10", 2L)
        );
    }

    @Test
    void should_return_empty_busy_hour_means_does_not_exists_when_asked_for_busy_hour_on_empty_log_file() {
        String logEntries = "";
        LogFile logFile = LogFile.from(logEntries);

        Optional<BusyHourSummary> busyHourSummary = logFile.findBusyHourSummary();
        assertThat(busyHourSummary).isEmpty();
    }

    @Test
    void should_return_latest_busy_hour_when_multiple_hours_has_same_entry_count_and_asked_for_busy_hour() {
        String logEntries = """
                2026-07-10T10:00:00 INFO : User login
                2026-07-10T10:30:00 WARN : High memory usage
                2026-07-10T11:00:00 INFO : User logout
                2026-07-10T11:30:00 ERROR : Payment failed
                """;
        LogFile logFile = LogFile.from(logEntries);

        Optional<BusyHourSummary> busyHourSummary = logFile.findBusyHourSummary();
        assertThat(busyHourSummary).isNotEmpty();
        assertThat(busyHourSummary.get()).isEqualTo(
                new BusyHourSummary("2026-07-10T11", 2L)
        );
    }
}
