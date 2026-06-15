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
}
