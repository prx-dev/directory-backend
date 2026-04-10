---
name: Clean Code
description: Skill for maintaining readability, low complexity, and maintainable implementation style
applies-to:
  - Code Reviewer
---

# Clean Code Skill

## Scope

This skill enforces maintainable, review-friendly code changes within
**directory-backend**.

## Core Practices

- Keep methods focused and cohesive.
- Use expressive naming for classes, methods, and variables.
- Remove dead code and avoid TODO/FIXME without issue tracking.
- Prefer small, atomic changes over broad refactors.

## Project Guardrails

- Keep controller -> service -> repository layering intact.
- Respect existing response/header patterns (`MESSAGE_HEADER`, `MESSAGE_ERROR_HEADER`).
- Do not refactor unrelated packages while implementing feature work.

## Outputs

1. Review notes on readability and maintainability.
2. Suggested simplifications with minimal behavior risk.
3. Follow-up checklist for technical debt items.

