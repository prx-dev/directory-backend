---
name: CI/CD Orchestration
description: Skill for coordinating build, verification, and quality gates in GitHub Actions
applies-to:
  - Project Manager
  - DevOps Engineer
---

# CI/CD Orchestration Skill

## Scope

This skill covers reliable CI/CD orchestration for the Maven-based
**directory-backend** service.

## Core Practices

- Keep pipelines aligned with repository workflows: `ci.yml`, `build.yml`, and `qodana_code_quality.yml`.
- Run CI-equivalent verification with `mvn -B -V -e clean verify`.
- Ensure coverage and static-analysis artifacts are published and reviewable.
- Optimize execution using deterministic steps and dependency caching.

## Project Guardrails

- Treat quality gates as release blockers (JaCoCo, PMD, Sonar/Qodana).
- Avoid workflow changes that alter public API behavior validation.
- Keep secrets in GitHub/Vault-managed storage; never hardcode tokens in workflow files.

## Outputs

1. Updated pipeline plans or workflow edits.
2. Quality-gate checklist per release candidate.
3. Rollback and remediation actions for failing gates.

