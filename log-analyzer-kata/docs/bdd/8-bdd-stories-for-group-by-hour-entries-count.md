## Group Log Entries By Hour

* Scenario:
  * Group log entries by hour
* Given:
  * 2026-07-10T10:00:00 INFO : User login
  * 2026-07-10T10:15:30 WARN : High memory usage
  * 2026-07-10T10:45:12 ERROR : Payment failed
  * 2026-07-10T11:05:10 INFO : User logout
  * 2026-07-10T11:20:05 ERROR : Database unavailable
* When:
  * We call groupByHour() method on LogFile instance
* Then:
  * It should return like below:
    * 2026-07-10T10 -> 3
    * 2026-07-10T11 -> 2