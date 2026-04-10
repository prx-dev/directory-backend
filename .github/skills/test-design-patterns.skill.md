---
name: Test Design Patterns
description: Skill for designing robust test scenarios and maintainable test structure
applies-to:
  - QA / Test Writer
---

# Test Design Patterns Skill

## Scope

This skill covers test-case design and structure patterns for reliable, readable
coverage in **directory-backend**.

## Core Practices

- Use Arrange/Act/Assert and clear test naming.
- Cover happy path, edge cases, and failure branches.
- Prefer parameterized tests for repeated scenario classes.
- Keep tests independent and deterministic.

## Project Guardrails

- Align tests with service-owned validation and response semantics.
- Include regression cases for compatibility-sensitive `/api/v1/*` behavior.
- Keep tests minimal, focused, and easy to diagnose when failing.

## Outputs

1. Scenario matrix per feature.
2. Test class and method naming plan.
3. Branch-coverage-focused additions.

