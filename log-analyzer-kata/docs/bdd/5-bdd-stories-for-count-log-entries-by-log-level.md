## Count Log Entries By Log Level

* Scenario:
  * Find log entries count by log level
* Given:
  * 2026-07-10T10:00:00 INFO : User login
  * 2026-07-10T10:01:00 WARN : High memory usage
  * 2026-07-10T10:02:00 INFO : User logout
  * 2026-07-10T10:03:00 ERROR : Payment failed
  * 2026-07-10T10:04:00 ERROR : Database unavailable
* When:
  * We call groupByLevel() method on LogFile instance
* Then:
  * It should return below Map<LogLevel, Long>
    * INFO : 2
    * WARN : 1
    * ERROR : 2