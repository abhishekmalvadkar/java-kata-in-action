## Total Entries in Log File

* Scenario:
  * Find total log entries in filled file
* Given:
  * 2026-07-10T10:00:00 INFO : User login
  * 2026-07-10T10:01:00 WARN : High memory usage
  * 2026-07-10T10:02:00 ERROR : Payment failed
* When:
  * We call entryCount() method on LogFile instance
* Then:
  * It should return 3

* Scenario:
  * Find total log entries in empty file
* Given:
  * Empty log file
* When:
  * We call entryCount() method on LogFile instance
* Then:
  * It should return 0