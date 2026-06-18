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
}
