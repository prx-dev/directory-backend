---
name: Spring Data JPA
description: Skill for repository design, specifications, and data-access behavior
applies-to:
  - Database Architect
---

# Spring Data JPA Skill

## Scope

This skill covers Spring Data repository patterns and specification-driven queries
for **directory-backend**.

## Core Practices

- Design repository interfaces around aggregate access patterns.
- Prefer `JpaSpecificationExecutor` for dynamic filtering use cases.
- Ensure pagination and sorting semantics are explicit and tested.
- Keep custom queries minimal and justified by measurable need.

## Project Guardrails

- Preserve campaign filtering compatibility, including legacy aliases.
- Keep repository changes aligned with service validation behavior.
- Confirm data-access updates remain compatible with existing API contracts.

## Outputs

1. Repository design or refactoring guidance.
2. Query behavior validation plan.
3. Performance and correctness considerations.

