---
name: Dependency Audit
description: Skill for auditing transitive dependencies, licenses, and update risk
applies-to:
  - Security Reviewer
---

# Dependency Audit Skill

## Scope

This skill performs dependency hygiene checks for **directory-backend** across
security, maintenance, and compatibility dimensions.

## Core Practices

- Review direct and transitive dependencies from `pom.xml` and lock-effective outputs.
- Check stale libraries, unsupported versions, and conflicting transitive trees.
- Evaluate risk before upgrades (API changes, framework alignment, test impact).
- Verify that build plugins remain compatible with Java 21 and Spring Boot 3.5.x.

## Project Guardrails

- Keep dependency changes atomic and traceable.
- Validate upgrades with at least `mvn -B -V -e clean verify`.
- Protect compatibility with `/api/v1/*` behavior during upgrades.

## Outputs

1. Dependency risk report.
2. Proposed upgrade sequence and rollback strategy.
3. Validation checklist for post-upgrade verification.

