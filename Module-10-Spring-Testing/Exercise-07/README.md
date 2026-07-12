# Exercise 7: Test Custom Repository Query

## Objective
Add and test a custom query method `findByName` in `UserRepository`.

## Technologies Used
- Java 17
- Spring Boot 3.2.0
- JUnit 5
- H2 Database
- `@DataJpaTest`
- Maven

## Solution Test (`Exercise7_CustomQueryTest.java`)
Test the `findByName` custom repository query using `@DataJpaTest` with an embedded H2 database.

## How to Run the Test
Navigate to this directory and run:
```bash
mvn test
```
