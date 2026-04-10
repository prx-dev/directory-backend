---
name: Dependency Check
description: Tool for checking Maven dependency vulnerabilities and updates
type: terminal
command-prefix: mvn
---

# Dependency Check Tool

## Purpose

Audit Maven dependencies for security vulnerabilities and available updates
in the **directory-backend** project.

## Available Commands

### Vulnerability Scanning

```bash
# OWASP dependency check (if plugin configured)
mvn org.owasp:dependency-check-maven:check

# View report
open target/dependency-check-report.html
```

### Version Management

```bash
# Check for dependency updates
mvn versions:display-dependency-updates

# Check for plugin updates
mvn versions:display-plugin-updates

# Check for property updates
mvn versions:display-property-updates
```

### Dependency Analysis

```bash
# Full dependency tree
mvn dependency:tree

# Analyze unused/undeclared dependencies
mvn dependency:analyze

# Show effective POM
mvn help:effective-pom
```

### Key Dependencies to Monitor

- `org.springframework.boot:spring-boot-starter-*` (current: 3.5.8)
- `org.springframework.cloud:spring-cloud-dependencies` (current: 2025.0.1)
- `org.postgresql:postgresql` (current: 42.7.7)
- `org.yaml:snakeyaml` (current: 2.5)
- `io.jsonwebtoken:jjwt-*` (current: 0.12.3)
- `org.mapstruct:mapstruct` (current: 1.6.3)
- `org.springdoc:springdoc-openapi-starter-webmvc-ui` (current: 2.6.0)
