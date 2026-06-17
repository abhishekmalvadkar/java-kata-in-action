## Handle Invalid log entry

* Scenario:
  * Parse invalid single log entry
* Given:
  * Log entry: "INFO : login"
* When:
  * We call parse() method on LogEntry
* Then:
  * It should throw InvalidLogEntryException with message "Invalid log entry, please provide valid log entry(e.g 2026-07-10T10:00:00 INFO : User login)"