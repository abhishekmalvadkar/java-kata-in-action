package com.amalvadkar.lak;

import com.amalvadkar.lak.domain.LogEntry;
import com.amalvadkar.lak.exceptions.InvalidLogEntryException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LogInValidEntryParseTest extends AbstractLogAnalyzerTest {
    @Test
    void should_throw_invalid_log_entry_exception_with_when_passed_invalid_log_entry() {
        assertThatThrownBy(() -> LogEntry.parse("INFO : login"))
                .isInstanceOf(InvalidLogEntryException.class)
                .hasMessage("Invalid log entry, please provide valid log entry(e.g 2026-07-10T10:00:00 INFO : User login)");
    }
}
