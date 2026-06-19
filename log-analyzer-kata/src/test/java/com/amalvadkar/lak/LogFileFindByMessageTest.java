package com.amalvadkar.lak;

import com.amalvadkar.lak.domain.LogEntry;
import com.amalvadkar.lak.domain.LogFile;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LogFileFindByMessageTest extends AbstractLogAnalyzerTest {
    @Test
    void should_return_entries_by_exact_message() {
        String logEntries = """
                2026-07-10T10:00:00 INFO : User login
                2026-07-10T10:01:00 WARN : High memory usage
                2026-07-10T10:02:00 INFO : User logout
                2026-07-10T10:03:00 ERROR : User login
                """;
        LogFile logFile = LogFile.from(logEntries);

        assertThat(logFile.findEntriesByMessage("User login")).containsExactly(
          LogEntry.from("2026-07-10T10:00:00", "INFO", "User login"),
          LogEntry.from("2026-07-10T10:03:00", "ERROR", "User login")
        );
    }
}
