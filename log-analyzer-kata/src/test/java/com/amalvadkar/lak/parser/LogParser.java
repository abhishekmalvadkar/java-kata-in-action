package com.amalvadkar.lak.parser;

import com.amalvadkar.lak.domain.LogEntry;
import com.amalvadkar.lak.enums.LogLevel;

import java.time.LocalDateTime;

public class LogParser {
    public LogEntry parse(String singleLogEntry) {
        String[] logEntryParts = singleLogEntry.split(" ");
        String timeStamp = logEntryParts[0];
        String logLevel = logEntryParts[1];
        String message = logEntryParts[2];
        LogEntry logEntry = new LogEntry();
        logEntry.setTimestamp(LocalDateTime.parse(timeStamp));
        logEntry.setLogLevel(LogLevel.valueOf(logLevel));
        logEntry.setMessage(message);
        return logEntry;
    }
}
