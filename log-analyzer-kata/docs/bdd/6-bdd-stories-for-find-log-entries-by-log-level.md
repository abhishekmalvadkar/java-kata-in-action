## Find Log Entries By Log Level

* Scenario:
  * Find log entries by INFO log level
* Given:
  * 2026-07-10T10:00:00 INFO : User login
  * 2026-07-10T10:01:00 WARN : High memory usage
  * 2026-07-10T10:02:00 INFO : User logout
  * 2026-07-10T10:03:00 ERROR : Payment failed
* When:
  * We call findEntriesByLevel(LogLevel.INFO) method on LogFile instance
* Then:
  * It should return 2 log entries like:
  * First log entry should contain
    * Timestamp : 2026-07-10T10:00:00
    * Log Level : INFO
    * Message : User login
  * Second log entry should contain:
    * Timestamp : 2026-07-10T10:02:00 INFO
    * Log Level : INFO
    * Message : User logout