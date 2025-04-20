# REFACTORING
# Movie Rental Refactoring (Inspired by Martin Fowler)

This project is a Java console application that demonstrates how to refactor messy, procedural code into clean, object-oriented design, inspired by Martin Fowler's book **"Refactoring: Improving the Design of Existing Code."**

---

## Project Description

The app simulates a simple **video rental store system**, where:
- A customer can rent different types of movies (Regular, Children’s, New Releases)
- The program calculates the total rental cost
- It also awards frequent renter points
- A clean **text statement** is generated

---

## Technologies Used

- Java (standard libraries)
- Console-based UI

---

## What Was Refactored

We started from a **long, procedural `statement()` method** in the `Customer` class. It was:
- Calculating charges
- Building strings
- Containing switch logic

This broke the **Single Responsibility Principle**.

### Refactoring Changes Made:

| Change | Why |
|-------|-----|
| Extracted `getCharge()` and `getFrequentRenterPoints()` to `Rental.java` | Logic belongs to the object it uses (Rental) |
| Replaced `Vector` and `Enumeration` with `List` and modern for-each | Cleaner, safer, and modern Java style |
| Broke down `statement()` into smaller methods (`header()`, `lineForRental()`, `footer()`) | Easier to read, test, and extend |
| Used `StringBuilder` and `String.format()` | Better performance and formatting |

---



