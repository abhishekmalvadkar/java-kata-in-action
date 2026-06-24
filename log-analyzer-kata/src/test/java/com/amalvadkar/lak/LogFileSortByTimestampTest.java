package com.amalvadkar.lak;

import com.amalvadkar.lak.domain.LogFile;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

public class LogFileSortByTimestampTest extends AbstractLogAnalyzerTest {
    @Test
    void should_return_entries_sort_by_timestamp_in_asc_order() {
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
}
