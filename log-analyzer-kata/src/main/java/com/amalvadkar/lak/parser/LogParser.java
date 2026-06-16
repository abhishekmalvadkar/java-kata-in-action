package com.amalvadkar.lak.parser;

import com.amalvadkar.lak.domain.LogEntry;

public class LogParser {
    public LogEntry parse(String singleLogEntry) {
        String[] logEntryParts = singleLogEntry.split("\\s+:\\s+");
        String logEntryNonMessagePart = logEntryParts[0];
        String logEntryMessagePart = logEntryParts[1];
        String[] logEntryNonMessageParts = logEntryNonMessagePart.split("\\s+");
        String timeStamp = logEntryNonMessageParts[0];
        String logLevel = logEntryNonMessageParts[1];
        return LogEntry.from(timeStamp, logLevel, logEntryMessagePart);
    }
}
