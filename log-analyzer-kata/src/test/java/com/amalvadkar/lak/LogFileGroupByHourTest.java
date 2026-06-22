package com.amalvadkar.lak;

import com.amalvadkar.lak.domain.LogFile;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class LogFileGroupByHourTest extends AbstractLogAnalyzerTest {
    @Test
    void should_return__hour_with_entry_count_when_ask_for_group_by_hour() {
        String logEntries = """
                2026-07-10T10:00:00 INFO : User login
                2026-07-10T10:15:30 WARN : High memory usage
                2026-07-10T10:45:12 ERROR : Payment failed
                2026-07-10T11:05:10 INFO : User logout
                2026-07-10T11:20:05 ERROR : Database unavailable
                """;
        LogFile logFile = LogFile.from(logEntries);

        assertThat(logFile.groupByHour()).containsExactlyInAnyOrderEntriesOf(
                Map.of("2026-07-10T10", 3L,
                        "2026-07-10T11", 2L)
        );
    }
}
