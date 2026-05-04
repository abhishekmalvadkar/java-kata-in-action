# FizzBuzz Kata

## Problem

Write a program that prints numbers from 1 to 100 with the following rules:

* If a number is divisible by 3, print **"Fizz"**
* If a number is divisible by 5, print **"Buzz"**
* If a number is divisible by both 3 and 5, print **"FizzBuzz"**
* Otherwise, print the number itself

---

## Example Output

```
1
2
Fizz
4
Buzz
Fizz
...
14
FizzBuzz
...
100
```

---

## Stage 2 – Extended Rules

Enhance the logic with additional conditions:

* A number is **Fizz** if:

    * it is divisible by 3, OR
    * it contains the digit 3

* A number is **Buzz** if:

    * it is divisible by 5, OR
    * it contains the digit 5

---

## Examples

* 53 → FizzBuzz (contains both 3 and 5)
* 35 → FizzBuzzBuzz (contains 3 and 5, and divisible by 5)

---

## Focus

* Clean code
* Test-driven development (TDD)
* Extensible rule design
* Refactoring techniques

---

## Notes

Original inspiration: https://codingdojo.org/kata/FizzBuzz/
