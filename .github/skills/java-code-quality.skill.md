---
name: Java Code Quality
description: Skill for reviewing Java 21 code quality, correctness, and maintainability
applies-to:
  - Code Reviewer
---

# Java Code Quality Skill

## Scope

This skill evaluates Java implementation quality in **directory-backend**,
including correctness, readability, and convention alignment.

## Core Practices

- Favor clear domain-centric naming and low cyclomatic complexity.
- Validate null handling, optional use, and exception safety.
- Confirm modern Java usage where it improves clarity (records, pattern matching).
- Ensure code changes are covered by appropriate tests.

## Project Guardrails

- Keep service-layer ownership of validation and `ResponseEntity` semantics.
- Prefer constants from `DirectoryAppConstants` over ad-hoc string literals.
- Preserve existing behavior for `/api/v1/*` endpoints.

## Outputs

1. Code quality findings with severity.
2. Refactoring suggestions constrained to requested scope.
3. Risk notes for merge readiness.

