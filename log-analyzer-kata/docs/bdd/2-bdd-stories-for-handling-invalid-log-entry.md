## Handle Invalid log entry

* Scenario:
  * Parse single log entry without timestamp
* Given:
  * Log entry: "INFO : login"
* When:
  * We call parse() method on LogParser
* Then:
  * It should throw InvalidLogEntryException with message "Missing Timestamp"