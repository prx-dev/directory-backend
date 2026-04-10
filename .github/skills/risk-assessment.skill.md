---
name: Risk Assessment
description: Skill for delivery risk identification, impact analysis, and mitigation planning
applies-to:
  - Project Manager
  - Repo Requirements Analyst
---

# Risk Assessment Skill

## Scope

This skill provides structured risk analysis for feature work, releases, and
operational changes in **directory-backend**.

## Core Practices

- Identify technical, delivery, security, and dependency risks.
- Score risks by likelihood, impact, and detectability.
- Define mitigation, contingency, and owner per risk.
- Reassess risk after major scope or dependency changes.

## Project Guardrails

- Highlight risks to `/api/v1/*` compatibility and external integrations first.
- Include quality-gate and test coverage risk in release readiness.
- Avoid speculative risks without evidence from code, pipeline, or requirements.

## Outputs

1. Risk register with priority tiers.
2. Mitigation and monitoring plan.
3. Release impact statement.

