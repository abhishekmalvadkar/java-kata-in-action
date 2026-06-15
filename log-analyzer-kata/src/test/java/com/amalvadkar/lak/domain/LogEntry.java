package com.amalvadkar.lak.domain;

import com.amalvadkar.lak.enums.LogLevel;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class LogEntry {
    private LocalDateTime timestamp;
    private LogLevel logLevel;
    private String message;
}
