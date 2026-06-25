package com.amalvadkar.lak;

import com.amalvadkar.lak.domain.LogFile;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LogFileSortByTimestampTest extends AbstractLogAnalyzerTest {
    @Test
    void should_return_entries_sort_by_timestamp_in_asc_order() {
        String logEntries = """
                2026-07-10T10:45:12 ERROR : Payment failed
                2026-07-10T10:00:00 INFO : User login
                2026-07-10T10:15:30 WARN : High memory usage
                """;
        LogFile logFile = LogFile.from(logEntries);

        assertThat(logFile.sortByTimeStampAsc()).isEqualTo("""
                2026-07-10T10:00 INFO : User login
                2026-07-10T10:15:30 WARN : High memory usage
                2026-07-10T10:45:12 ERROR : Payment failed""");
    }

    @Test
    void should_return_entries_sort_by_timestamp_in_desc_order() {
        String logEntries = """
                2026-07-10T10:45:12 ERROR : Payment failed
                2026-07-10T10:00:00 INFO : User login
                2026-07-10T10:15:30 WARN : High memory usage
                """;
        LogFile logFile = LogFile.from(logEntries);

        assertThat(logFile.sortByTimeStampDesc()).isEqualTo("""
                2026-07-10T10:45:12 ERROR : Payment failed
                2026-07-10T10:15:30 WARN : High memory usage
                2026-07-10T10:00:00 INFO : User login""");
    }
}
