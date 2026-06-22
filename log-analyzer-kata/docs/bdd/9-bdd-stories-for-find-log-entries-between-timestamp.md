## Find Log Entries Between Timestamps

* Scenario:
  * Find log entries within a time range
* Given:
  * 2026-07-10T10:00:00 INFO : User login
  * 2026-07-10T10:15:30 WARN : High memory usage
  * 2026-07-10T10:45:12 ERROR : Payment failed
  * 2026-07-10T11:05:10 INFO : User logout
  * 2026-07-10T11:20:05 ERROR : Database unavailable
* When:
  * We call entriesBetween(LocalDateTime start, LocalDateTime end) method on LogFile instance
    * start : 2026-07-10T10:10:00
    * end :   2026-07-10T11:10:00
* Then:
  * It should return like below:
    * 2026-07-10T10:15:30 WARN : High memory usage
    * 2026-07-10T10:45:12 ERROR : Payment failed
    * 2026-07-10T11:05:10 INFO : User logout