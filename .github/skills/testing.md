# Skill: Testing & Coverage

Purpose

- Author and maintain tests to ensure behavior and satisfy coverage gates.

Inputs

- Source files or modules to test
- Coverage targets (e.g., 80% line)

Outputs

- JUnit test classes, mock setups, integration tests
- Coverage reports (JaCoCo)

Preconditions

- Project's test profile and build system available (Maven)

Typical steps

1. Identify code paths requiring tests.
2. Write focused unit tests (edge cases + happy paths).
3. Run `mvn -Dtest=... test` and fix failures.
4. Generate JaCoCo report: `mvn clean test jacoco:report` and confirm coverage.
5. Commit tests and open PR with coverage evidence.

