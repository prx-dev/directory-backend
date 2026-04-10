---
name: Spring Boot Best Practices
description: Skill for applying Spring Boot patterns aligned with project conventions
applies-to:
  - Code Reviewer
---

# Spring Boot Best Practices Skill

## Scope

This skill enforces Spring Boot implementation conventions in **directory-backend**.

## Core Practices

- Keep controllers thin and delegate business logic to services.
- Use constructor injection and focused bean responsibilities.
- Apply transactional boundaries at service methods that mutate data.
- Use validation and exception handling patterns consistent with existing endpoints.

## Project Guardrails

- Preserve controller -> service -> repository flow.
- Keep services responsible for `ResponseEntity` and header semantics.
- Maintain backward compatibility for `/api/v1/*` contracts.

## Outputs

1. Best-practice compliance review notes.
2. Targeted corrective recommendations.
3. Verification points for tests and API behavior.

