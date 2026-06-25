package com.amalvadkar.lak.domain;

import com.amalvadkar.lak.enums.LogLevel;
import com.amalvadkar.lak.exceptions.InvalidLogEntryException;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class LogEntry {
    private static final String LOG_FORMAT_REGEX = "^(\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2})\\s+(INFO|WARN|ERROR)\\s+:\\s+(.+)$";

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
        validate(singleLogEntry);
        return parseValid(singleLogEntry);
    }

    private static void validate(String singleLogEntry) {
        if (isNotValid(singleLogEntry)) throw new InvalidLogEntryException();
    }

    private static boolean isNotValid(String singleLogEntry) {
        return !singleLogEntry.trim().matches(LOG_FORMAT_REGEX);
    }

    private static LogEntry parseValid(String singleLogEntry) {
        String[] logEntryParts = singleLogEntry.split("\\s+:\\s+");
        String logEntryNonMessagePart = logEntryParts[0].trim();
        String logEntryMessagePart = logEntryParts[1].trim();
        String[] logEntryNonMessageParts = logEntryNonMessagePart.split("\\s+");
        String timeStamp = logEntryNonMessageParts[0];
        String logLevel = logEntryNonMessageParts[1];
        return from(timeStamp, logLevel, logEntryMessagePart);
    }

    public String format() {
        return String.format("%s %s : %s",
                timestamp,
                logLevel,
                message);
    }

    public boolean withinRangeInclusive(LocalDateTime from, LocalDateTime to) {
        return (timestamp.isAfter(from) && timestamp.isBefore(to) ||
                (timestamp.isEqual(from) || timestamp.isEqual(to)));
    }
}
