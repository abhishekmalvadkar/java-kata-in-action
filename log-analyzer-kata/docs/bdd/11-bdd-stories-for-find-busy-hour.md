## Find busy hour

* Scenario:
  * Find the busiest hour
* Given:
  * 2026-07-10T10:00:00 INFO : User login
  * 2026-07-10T10:15:30 WARN : High memory usage
  * 2026-07-10T10:45:12 ERROR : Payment failed
  * 2026-07-10T11:05:10 INFO : User logout
  * 2026-07-10T11:20:05 ERROR : Database unavailable
* When:
  * We call findBusyHourSummary() method on LogFile instance
* Then:
  * It should return like below:
    * Hour : 2026-07-10T10
    * Entry Count : 3


* Scenario:
  * Find the busiest hour when multiple hours have the same highest number of entries
* Given:
  * 2026-07-10T10:00:00 INFO : User login
  * 2026-07-10T10:30:00 WARN : High memory usage
  * 2026-07-10T11:00:00 INFO : User logout
  * 2026-07-10T11:30:00 ERROR : Payment failed
* When:
  * We call findBusyHourSummary() method on LogFile instance
* Then:
  * It should return the latest hour:
    * Hour : 2026-07-10T11
    * Entry Count : 2
