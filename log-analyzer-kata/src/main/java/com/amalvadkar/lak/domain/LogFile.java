package com.amalvadkar.lak.domain;

import com.amalvadkar.lak.enums.LogLevel;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

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

    public boolean isEmpty() {
        return entryCount() == 0L;
    }

    public List<LogEntry> entries() {
        return entries;
    }

    public Map<LogLevel, Long> groupByLevel() {
        return entries.stream()
                .collect(groupingBy(LogEntry::getLogLevel,counting()));
    }

    public List<LogEntry> findEntriesByLevel(LogLevel logLevel) {
        return entries.stream()
                .filter(ifMatchWithGiven(logLevel))
                .toList();
    }

    private static Predicate<LogEntry> ifMatchWithGiven(LogLevel logLevel) {
        return logEntry -> logEntry.getLogLevel() == logLevel;
    }

    public List<LogEntry> findEntriesByMessage(String message) {
        return List.of();
    }
}
