package com.amalvadkar.lak;

import com.amalvadkar.lak.domain.LogEntry;
import com.amalvadkar.lak.domain.LogFile;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LogFileTest extends AbstractLogAnalyzerTest {
    @Test
    void should_from_multiple_log_entries() {
        String logEntries = """
                2026-07-10T10:00:00 INFO : User login
                2026-07-10T10:01:00 WARN : High memory usage
                2026-07-10T10:02:00 ERROR : Payment failed
                """;
        LogFile logFile = LogFile.from(logEntries);

        assertThat(logFile.entryCount()).isEqualTo(3L);
        assertThat(logFile.entries()).containsExactly(
                LogEntry.from("2026-07-10T10:00:00", "INFO", "User login"),
                LogEntry.from("2026-07-10T10:01:00", "WARN", "High memory usage"),
                LogEntry.from("2026-07-10T10:02:00", "ERROR", "Payment failed")
        );
    }
}
