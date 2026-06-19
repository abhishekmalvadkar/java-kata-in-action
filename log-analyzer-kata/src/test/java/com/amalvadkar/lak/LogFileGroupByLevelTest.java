package com.amalvadkar.lak;

import com.amalvadkar.lak.domain.LogFile;
import com.amalvadkar.lak.enums.LogLevel;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class LogFileGroupByLevelTest extends AbstractLogAnalyzerTest {
    @Test
    void should_count_entries_by_log_level() {
        String logEntries = """
                2026-07-10T10:00:00 INFO : User login
                2026-07-10T10:01:00 WARN : High memory usage
                2026-07-10T10:02:00 INFO : User logout
                2026-07-10T10:03:00 ERROR : Payment failed
                2026-07-10T10:04:00 ERROR : Database unavailable
                """;
        LogFile logFile = LogFile.from(logEntries);

        assertThat(logFile.groupByLevel()).containsExactlyInAnyOrderEntriesOf(
                Map.of(
                        LogLevel.INFO, 2L,
                        LogLevel.WARN, 1L,
                        LogLevel.ERROR, 2L
                )
        );
    }

    @Test
    void should_count_entries_by_log_level_when_only_one_log_level_exists() {
        String logEntries = """
                2026-07-10T10:00:00 INFO : User login
                2026-07-10T10:01:00 INFO : User logout
                """;
        LogFile logFile = LogFile.from(logEntries);

        assertThat(logFile.groupByLevel()).containsExactlyInAnyOrderEntriesOf(
                Map.of(LogLevel.INFO, 2L)
        );
    }

    @Test
    void should_count_entries_by_log_level_when_only_file_is_empty() {
        String logEntries = "";
        LogFile logFile = LogFile.from(logEntries);

        assertThat(logFile.groupByLevel()).isEmpty();
    }
}
