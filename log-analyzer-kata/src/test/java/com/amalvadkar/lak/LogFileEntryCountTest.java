package com.amalvadkar.lak;

import com.amalvadkar.lak.domain.LogFile;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LogFileEntryCountTest extends AbstractLogAnalyzerTest {
    @Test
    void should_return_3_as_total_entries_in_log_file() {
        String logEntries = """
                2026-07-10T10:00:00 INFO : User login
                2026-07-10T10:01:00 WARN : High memory usage
                2026-07-10T10:02:00 ERROR : Payment failed
                """;
        LogFile logFile = LogFile.from(logEntries);

        assertThat(logFile.entryCount()).isEqualTo(3L);
    }

    @Test
    void should_inform_log_file_is_empty_if_it_does_not_have_any_entries() {
        String logEntries = "";
        LogFile logFile = LogFile.from(logEntries);

        assertThat(logFile.isEmpty()).isTrue();
    }
}
