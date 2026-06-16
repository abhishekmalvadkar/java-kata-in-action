## Parse log entry

* Scenario:
  * Parse single log entry with single word log message
* Given:
  * Log entry: "2026-07-10T10:00:00 INFO : login"
* When:
  * We call parse() method on LogParser
* Then:
  * It should give LogEntry object which should have below things:
    * Timestamp : 2026-07-10T10:00:00
    * Log level : INFO
    * Message : login

* Scenario:
  * Parse single log entry with multi word log message
* Given:
  * Log entry: "2026-07-10T10:00:00 INFO : User login"
* When:
  * We call parse() method on LogParser
* Then:
  * It should give LogEntry object which should have below things:
    * Timestamp : 2026-07-10T10:00:00
    * Log level : INFO
    * Message : User login

* Scenario:
  * Parse single log entry with more spaces in the middle
* Given:
  * Log entry: "2026-07-10T10:00:00        INFO     :      User login"
* When:
  * We call parse() method on LogParser
* Then:
  * It should give LogEntry object which should have below things:
    * Timestamp : 2026-07-10T10:00:00
    * Log level : INFO
    * Message : User login

* Scenario:
  * Parse single log entry with more leading and trailing spaces
* Given:
  * Log entry: "               2026-07-10T10:00:00        INFO     :      User login              "
* When:
  * We call parse() method on LogParser
* Then:
  * It should give LogEntry object which should have below things:
    * Timestamp : 2026-07-10T10:00:00
    * Log level : INFO
    * Message : User login