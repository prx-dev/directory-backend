---
name: Mockito Mocking
description: Skill for isolated unit testing with Mockito in service and controller tests
applies-to:
  - QA / Test Writer
---

# Mockito Mocking Skill

## Scope

This skill provides Mockito usage patterns for **directory-backend** unit tests,
with emphasis on deterministic behavior and focused assertions.

## Core Practices

- Use `@ExtendWith(MockitoExtension.class)` for pure unit tests.
- Mock repository and client boundaries; keep real logic in the subject under test.
- Verify interactions only when behavior is interaction-driven.
- Prefer descriptive stubs and avoid over-mocking implementation details.

## Project Guardrails

- Keep service tests aligned with controller -> service -> repository layering.
- Validate response headers/messages where service methods build `ResponseEntity`.
- Ensure tests cover compatibility-sensitive behavior for `/api/v1/*` endpoints.

## Outputs

1. Unit test scaffolding with mock setup.
2. Interaction and state assertion plan.
3. Edge-case test scenarios for error handling.

