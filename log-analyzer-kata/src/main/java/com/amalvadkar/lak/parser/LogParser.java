package com.amalvadkar.lak.parser;

import com.amalvadkar.lak.domain.LogEntry;

public class LogParser {
    public LogEntry parse(String singleLogEntry) {
        String[] logEntryParts = singleLogEntry.split(" ");
        String timeStamp = logEntryParts[0];
        String logLevel = logEntryParts[1];
        String message = logEntryParts[2];
        return LogEntry.from(timeStamp, logLevel, message);
    }
}
