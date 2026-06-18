package com.amalvadkar.lak.domain;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class LogFile {
    private final List<LogEntry> entries;

    public static LogFile from(String logEntries) {
        return new LogFile(parse(logEntries));
    }

    private static List<LogEntry> parse(String logEntries) {
        return logEntries.lines()
                .map(LogEntry::parse)
                .toList();
    }

    public long entryCount() {
        return entries.size();
    }

    public List<LogEntry> entries() {
        return entries;
    }
}
