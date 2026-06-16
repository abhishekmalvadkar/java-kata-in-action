package com.amalvadkar.lak.parser;

import com.amalvadkar.lak.domain.LogEntry;

public class LogParser {
    public LogEntry parse(String singleLogEntry) {
        String[] logEntryParts = singleLogEntry.split(" : ");
        String logEntryNonMessagePart = logEntryParts[0];
        String[] logEntryNonMessageParts = logEntryNonMessagePart.split(" ");
        String timeStamp = logEntryNonMessageParts[0];
        String logLevel = logEntryNonMessageParts[1];
        String message = logEntryParts[1];
        return LogEntry.from(timeStamp, logLevel, message);
    }
}
