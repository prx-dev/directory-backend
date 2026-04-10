---
name: Spring Boot Testing
description: Skill for Spring context, MVC, and integration testing patterns
applies-to:
  - QA / Test Writer
---

# Spring Boot Testing Skill

## Scope

This skill covers Spring-based test slices and integration tests used in
**directory-backend**.

## Core Practices

- Use `@WebMvcTest` for controller contracts and delegation behavior.
- Use `@DataJpaTest` for repository/query behavior with H2.
- Use `@SpringBootTest` only when full-context behavior is required.
- Keep tests isolated, deterministic, and focused on observable outcomes.

## Project Guardrails

- Use test profile settings from `src/test/resources/application-test.yml`.
- Validate response headers/messages for endpoints relying on constants.
- Ensure compatibility-sensitive `/api/v1/*` behavior remains covered.

## Outputs

1. Spring test plan by layer.
2. Test class scaffolding and profile guidance.
3. Coverage-focused scenario matrix.

