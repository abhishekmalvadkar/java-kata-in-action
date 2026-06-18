## Handle Multiple log entries

* Scenario:
  * Parse multiple log entries
* Given:
  * 2026-07-10T10:00:00 INFO : User login
  * 2026-07-10T10:01:00 WARN : High memory usage
  * 2026-07-10T10:02:00 ERROR : Payment failed
* When:
  * We call parse() method on LogFile
* Then:
  * It should return 3 log entries like:
  * First log entry should contain
    * Timestamp : 2026-07-10T10:00:00
    * Log Level : INFO
    * Message : User login
  * Second log entry should contain:
    * Timestamp : 2026-07-10T10:01:00
    * Log Level : WARN
    * Message : High memory usage
  * Third log entry should contain:
    * Timestamp : 2026-07-10T10:02:00
    * Log Level : ERROR
    * Message : Payment failed