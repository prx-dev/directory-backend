---
name: Maven Build
description: Skill for building, verifying, and troubleshooting Maven-based project workflows
applies-to:
  - DevOps Engineer
---

# Maven Build Skill

## Scope

This skill covers Maven build orchestration for **directory-backend** and CI-aligned validation.

## Core Practices

- Use project wrapper or configured Maven runtime consistently.
- Run CI-equivalent verification when validating production readiness.
- Isolate failing modules, tests, and plugins with targeted commands.
- Preserve reproducibility by avoiding environment-dependent behavior.

## Project Guardrails

- Keep plugin versions aligned with `pom.xml` properties and dependency management.
- Use `mvn -B -V -e clean verify` for release-level confidence checks.
- Do not bypass quality gates without explicit decision and documented risk.

## Outputs

1. Build execution plan for local and CI contexts.
2. Failure triage notes (compile/test/plugin/dependency).
3. Recommended fixes and re-run commands.

