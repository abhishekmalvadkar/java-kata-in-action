package com.amalvadkar.lak;

import com.amalvadkar.lak.domain.LogEntry;
import com.amalvadkar.lak.domain.LogFile;
import com.amalvadkar.lak.enums.LogLevel;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LogFileFindByLevelTest extends AbstractLogAnalyzerTest {
    @Test
    void should_return_entries_by_info_log_level() {
        String logEntries = """
                2026-07-10T10:00:00 INFO : User login
                2026-07-10T10:01:00 WARN : High memory usage
                2026-07-10T10:02:00 INFO : User logout
                2026-07-10T10:03:00 ERROR : Payment failed
                """;
        LogFile logFile = LogFile.from(logEntries);

        assertThat(logFile.findEntriesByLevel(LogLevel.INFO)).containsExactly(
          LogEntry.from("2026-07-10T10:00:00", "INFO", "User login"),
          LogEntry.from("2026-07-10T10:02:00", "INFO", "User logout")
        );
    }

    @Test
    void should_return_entries_by_error_log_level() {
        String logEntries = """
                2026-07-10T10:00:00 INFO : User login
                2026-07-10T10:01:00 ERROR : Payment failed
                2026-07-10T10:02:00 ERROR : Database unavailable
                """;
        LogFile logFile = LogFile.from(logEntries);

        assertThat(logFile.findEntriesByLevel(LogLevel.ERROR)).containsExactly(
                LogEntry.from("2026-07-10T10:01:00", "ERROR", "Payment failed"),
                LogEntry.from("2026-07-10T10:02:00", "ERROR", "Database unavailable")
        );
    }

    @Test
    void should_return_empty_collection_when_asked_entries_does_not_exists_for_give_log_level() {
        String logEntries = "2026-07-10T10:00:00 INFO : User login";
        LogFile logFile = LogFile.from(logEntries);

        assertThat(logFile.findEntriesByLevel(LogLevel.ERROR)).isEmpty();
    }

    @Test
    void should_return_empty_collection_when_asked_entries_by_log_level_on_empty_file() {
        String logEntries = "";
        LogFile logFile = LogFile.from(logEntries);

        assertThat(logFile.findEntriesByLevel(LogLevel.ERROR)).isEmpty();
    }
}
