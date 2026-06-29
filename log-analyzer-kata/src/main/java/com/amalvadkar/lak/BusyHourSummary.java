package com.amalvadkar.lak;

import java.util.Map;

public record BusyHourSummary(String hour, long entryCount) {
    public BusyHourSummary(Map .Entry<String, Long> entry) {
        this(entry.getKey(), entry.getValue());
    }
}
