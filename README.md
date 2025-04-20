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

I started from a **long, procedural `statement()` method** in the `Customer` class. It was:
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

## Testing the Application

This project includes a full **JUnit 5 (Jupiter)** test suite.  
The tests cover all the core components of the application to ensure correctness and easy future maintenance.

### Test Coverage

| Class        | Test Class        | Coverage Description                                      |
|--------------|-------------------|------------------------------------------------------------|
| `Customer`   | `CustomerTest`    | Tests statement generation and frequent renter points      |
| `Rental`     | `RentalTest`      | Tests charge calculation and bonus point logic             |
| `Movie`      | `MovieTest`       | Tests title and price code getter/setter methods           |

---

### Running the Tests (Manual CLI Method)

Make sure you have [JUnit Console Standalone](https://repo1.maven.org/maven2/org/junit/platform/junit-platform-console-standalone/1.12.2/junit-platform-console-standalone-1.12.2.jar) downloaded in your `lib/` folder.

#### 1. Compile everything:

```bash
javac -cp ".:lib/junit-platform-console-standalone-1.12.2.jar" -d bin src/*.java test/*.java

#### 2. Run the tests:
java -jar lib/junit-platform-console-standalone-1.12.2.jar --class-path bin --scan-class-path

### 3.Output

├─ JUnit Jupiter ✔
│  ├─ MovieTest ✔
│  │  └─ testMovieGettersAndSetters() ✔
│  ├─ CustomerTest ✔
│  │  ├─ testFrequentRenterPointsForNewReleaseOneDay() ✔
│  │  └─ testStatementWithMultipleRentals() ✔
│  └─ RentalTest ✔
│     ├─ testFrequentRenterPointsStandard() ✔
│     ├─ testGetChargeForRegularMovie() ✔
│     ├─ testGetChargeForChildrensMovie() ✔
│     ├─ testGetChargeForNewRelease() ✔
│     └─ testFrequentRenterPointsBonus() ✔

