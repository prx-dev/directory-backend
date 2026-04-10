---
name: Quality Gates
description: Skill for enforcing release quality thresholds across tests and static analysis
applies-to:
  - Project Manager
---

# Quality Gates Skill

## Scope

This skill defines release-blocking quality checks for **directory-backend**.

## Core Practices

- Validate JaCoCo thresholds (80% line at bundle, 50% branch at package).
- Ensure PMD, Sonar, and Qodana checks are green.
- Confirm critical tests and contract validations pass.
- Track gate ownership and remediation SLAs.

## Project Guardrails

- Do not treat failing gates as advisory for release candidates.
- If exceptions are needed, capture explicit risk acceptance and follow-up actions.
- Include API compatibility validation for `/api/v1/*` behavior.

## Outputs

1. Gate status checklist.
2. Blocker list with owners and ETAs.
3. Release go/no-go recommendation.

