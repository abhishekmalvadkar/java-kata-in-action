package com.amalvadkar.lak.domain;

import com.amalvadkar.lak.enums.LogLevel;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class LogEntry {
    private final LocalDateTime timestamp;
    private final LogLevel logLevel;
    private final String message;

    public static LogEntry from(String timeStamp, String logLevel, String message) {
        return new LogEntry(
                LocalDateTime.parse(timeStamp),
                LogLevel.valueOf(logLevel),
                message
        );
    }

    public static LogEntry parse(String singleLogEntry) {
        String[] logEntryParts = singleLogEntry.split("\\s+:\\s+");
        String logEntryNonMessagePart = logEntryParts[0].trim();
        String logEntryMessagePart = logEntryParts[1].trim();
        String[] logEntryNonMessageParts = logEntryNonMessagePart.split("\\s+");
        String timeStamp = logEntryNonMessageParts[0];
        String logLevel = logEntryNonMessageParts[1];
        return from(timeStamp, logLevel, logEntryMessagePart);
    }
}
