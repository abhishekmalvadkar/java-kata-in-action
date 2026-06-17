package com.amalvadkar.lak.exceptions;

public class InvalidLogEntryException extends RuntimeException {
    public InvalidLogEntryException() {
        super("Invalid log entry, please provide valid log entry(e.g 2026-07-10T10:00:00 INFO : User login)");
    }
}
