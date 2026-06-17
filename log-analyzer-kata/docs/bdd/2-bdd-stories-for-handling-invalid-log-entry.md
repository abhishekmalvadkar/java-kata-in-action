## Handle Invalid log entry

* Scenario:
  * Parse single log entry without timestamp
* Given:
  * Log entry: "INFO : login"
* When:
  * We call parse() method on LogEntry
* Then:
  * It should throw IncompleteLogEntryException with message "Incomplete log entry"