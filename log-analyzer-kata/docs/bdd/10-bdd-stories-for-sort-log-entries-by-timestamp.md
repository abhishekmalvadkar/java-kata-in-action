## Sort Log Entries By Timestamps

* Scenario:
  * Sort log entries in ascending order
* Given:
  * 2026-07-10T10:45:12 ERROR : Payment failed
  * 2026-07-10T10:00:00 INFO : User login
  * 2026-07-10T10:15:30 WARN : High memory usage
* When:
  * We call sortByTimestampAsc() method on LogFile instance
* Then:
  * It should return like below:
    * 2026-07-10T10:00:00 INFO : User login
    * 2026-07-10T10:15:30 WARN : High memory usage
    * 2026-07-10T10:45:12 ERROR : Payment failed

* Scenario:
  * Sort log entries in descending order
* Given:
  * 2026-07-10T10:45:12 ERROR : Payment failed
  * 2026-07-10T10:00:00 INFO : User login
  * 2026-07-10T10:15:30 WARN : High memory usage
* When:
  * We call sortByTimestampDesc() method on LogFile instance
* Then:
  * It should return like below:
    * 2026-07-10T10:45:12 ERROR : Payment failed
    * 2026-07-10T10:15:30 WARN : High memory usage
    * 2026-07-10T10:00:00 INFO : User login
