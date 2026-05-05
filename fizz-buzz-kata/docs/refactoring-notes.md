## Refactoring Notes

### Item 1 : Copy and Paste is a hint

* When you are doing copy and paste anything then it's hint that you are doing something wrong
* It's telling you that think about re-usability and achieve it using apparition below techniques
  * Extract as method
  * Extract as constant
  * Extract as variable

### Item 2 : Get rid of magic strings

* Use constants with meaningful domain close name for magic strings because magic strings are not understandable

### Item 3 : Minimize visibility

* Do not expose all the things from object
* Always start with private and upgrade only when needed
* If you give less access then you will have less issues with object state
