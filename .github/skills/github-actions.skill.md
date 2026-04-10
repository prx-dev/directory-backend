---
name: GitHub Actions
description: Skill for authoring and reviewing GitHub Actions workflow definitions
applies-to:
  - DevOps Engineer
---

# GitHub Actions Skill

## Scope

This skill focuses on maintaining workflow reliability and clear automation in
GitHub Actions for **directory-backend**.

## Core Practices

- Keep jobs deterministic and explicit about Java/Maven setup.
- Reuse caching responsibly to reduce pipeline time.
- Separate verification concerns (build, quality, security) for fast diagnosis.
- Publish actionable artifacts (coverage, SARIF, logs) for reviewers.

## Project Guardrails

- Preserve required checks tied to branch policies.
- Avoid introducing unreviewed third-party actions.
- Ensure workflow edits align with existing quality gates and release process.

## Outputs

1. Workflow updates with rationale.
2. Trigger and permissions review notes.
3. Failure triage guide for pipeline maintainers.

