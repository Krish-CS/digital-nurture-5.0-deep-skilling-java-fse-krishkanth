# Exercise 2: Test Suites and Categories

## Scenario
You want to group related tests into a test suite and categorize them.

## Steps
1. Create a test suite class `AllTests`.
2. Add multiple test classes to the suite.
3. Use JUnit's `@Suite` and `@SelectClasses` annotations.

## Solution Code

```java
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({ CalculatorTest.class, EvenCheckerTest.class })
public class AllTests {
    // This class runs all selected test classes as a suite
}
```

## Output
```
Suite 'AllTests' executed:
  CalculatorTest  — Tests run: 3, Failures: 0
  EvenCheckerTest — Tests run: 10, Failures: 0
```
