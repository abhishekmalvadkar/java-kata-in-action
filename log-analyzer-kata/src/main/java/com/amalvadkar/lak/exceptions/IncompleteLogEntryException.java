package com.amalvadkar.lak.exceptions;

public class IncompleteLogEntryException extends RuntimeException {
    public IncompleteLogEntryException() {
        super("Incomplete log entry");
    }
}
