## Find Log Entries By Exact Log Message

* Scenario:
  * Find log entries by exact log message
* Given:
  * 2026-07-10T10:00:00 INFO : User login
  * 2026-07-10T10:01:00 WARN : High memory usage
  * 2026-07-10T10:02:00 INFO : User logout
  * 2026-07-10T10:03:00 ERROR : User login
* When:
  * We call findEntriesByMessage("User login") method on LogFile instance
* Then:
  * It should return 2 log entries like:
  * First log entry should contain
    * Timestamp : 2026-07-10T10:00:00
    * Log Level : INFO
    * Message : User login
  * Second log entry should contain:
    * Timestamp : 2026-07-10T10:02:00
    * Log Level : ERROR
    * Message : User login