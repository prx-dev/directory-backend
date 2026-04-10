---
name: JaCoCo Coverage
description: Skill for managing code coverage with JaCoCo
applies-to:
  - QA / Test Writer
  - Project Manager
---

# JaCoCo Coverage Skill

## Scope

This skill covers JaCoCo code coverage configuration, thresholds, and reporting
for the **directory-backend** project.

## Configuration

JaCoCo is configured in `pom.xml` with:

- **Plugin version**: 0.8.14
- **Report formats**: XML + HTML
- **Output**: `target/site/jacoco/`

## Thresholds

### Bundle Level (BUNDLE)
- **LINE coverage**: minimum 0.80 (80%)

### Package Level (PACKAGE)
- **BRANCH coverage**: minimum 0.50 (50%)

## Exclusions

Configured via `sonar.exclusions` property:
- XML files, Application class, exceptions, utilities, config, mappers
- Test classes, cache, security, producers, interceptors

## Commands

```bash
# Generate coverage report
mvn clean test jacoco:report

# With coverage profile
mvn -P coverage clean verify

# View report
open target/site/jacoco/index.html

# XML report for Sonar
# Located at: target/site/jacoco/jacoco.xml
```

## Troubleshooting

- If coverage drops below threshold, the `jacoco-check` execution will fail the build.
- Focus on service classes and controllers for maximum coverage impact.
- MapStruct-generated code is excluded from coverage.
