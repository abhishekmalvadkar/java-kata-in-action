package com.amalvadkar.lak.domain;

import com.amalvadkar.lak.BusyHourSummary;
import com.amalvadkar.lak.enums.LogLevel;
import com.amalvadkar.lak.enums.Sort;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;

import static com.amalvadkar.lak.domain.LogEntry.comparingTimestamp;
import static java.lang.String.format;
import static java.util.Map.Entry.comparingByValue;
import static java.util.stream.Collectors.*;

@RequiredArgsConstructor
public class LogFile {
    private static final String WITH_NEW_LINE = "\n";

    private final List<LogEntry> entries;

    public static LogFile from(String logEntries) {
        return new LogFile(parse(logEntries));
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
        return findEntriesBy(logEntry -> logEntry.getLogLevel() == logLevel);
    }

    public List<LogEntry> findEntriesByMessage(String message) {
        return findEntriesBy(logEntry -> logEntry.getMessage().equals(message));
    }

    private List<LogEntry> findEntriesBy(Predicate<LogEntry> predicate) {
        return entries.stream()
                .filter(predicate)
                .toList();
    }

    private static List<LogEntry> parse(String logEntries) {
        return logEntries.lines()
                .map(LogEntry::parse)
                .toList();
    }

    public Map<String, Long> groupEntryCountByHour() {
        return entries.stream()
                .collect(groupingBy(LogFile::formatAsDateHourOnly, counting()));
    }

    private static String formatAsDateHourOnly(LogEntry logEntry) {
        LocalDateTime timestamp = logEntry.getTimestamp();
        return format("%sT%s", timestamp.toLocalDate(), timestamp.getHour());
    }

    public String entriesBetween(LocalDateTime from, LocalDateTime to) {
        return entries.stream()
                .filter(ifRangeMatchInclusive(from, to))
                .map(LogEntry::format)
                .collect(joining(WITH_NEW_LINE));
    }

    private static Predicate<LogEntry> ifRangeMatchInclusive(LocalDateTime from, LocalDateTime to) {
        return logEntry -> logEntry.withinRangeInclusive(from, to);
    }

    public String sortByTimeStamp(Sort sort) {
        return entries.stream()
                .sorted(comparingTimestamp(sort))
                .map(LogEntry::format)
                .collect(joining(WITH_NEW_LINE));
    }

    public Optional<BusyHourSummary> findBusyHourSummary() {
        Map<String, Long> hourToEntryCountMap = groupEntryCountByHour();
        return hourToEntryCountMap.entrySet().stream()
                .max(comparingByValue())
                .map(BusyHourSummary::new);
    }
}
