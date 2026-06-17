package com.amalvadkar.lak;

import com.amalvadkar.lak.domain.LogEntry;
import com.amalvadkar.lak.exceptions.IncompleteLogEntryException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LogInValidEntryParseTest extends AbstractLogAnalyzerTest {
    @Test
    void should_throw_invalid_log_entry_exception_with_message_timestamp_missing_when_passed_log_message_without_timestamp() {
        assertThatThrownBy(() -> LogEntry.parse("INFO : login"))
                .isInstanceOf(IncompleteLogEntryException.class)
                .hasMessage("Incomplete log entry");
    }
}
