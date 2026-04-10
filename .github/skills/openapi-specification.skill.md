---
name: OpenAPI Specification
description: Skill for editing and validating OpenAPI contract definitions for v1 APIs
applies-to:
  - Product Owner
  - API Reviewer
---

# OpenAPI Specification Skill

## Scope

This skill governs updates to `src/main/resources/api/index.yaml` and ensures it
stays consistent with Java `*Api.java` interfaces.

## Core Practices

- Define paths, operations, schemas, and responses with complete metadata.
- Keep examples valid and aligned with DTO fields.
- Document error cases and common headers.
- Validate spec syntax and semantic consistency before merge.

## Project Guardrails

- Any API contract change requires synchronized updates in both `*Api.java` and `index.yaml`.
- Preserve `/api/v1/*` compatibility unless a break is explicitly approved.
- Keep legacy campaign filter aliases documented where applicable.

## Outputs

1. OpenAPI patch with path/schema updates.
2. Contract diff notes for reviewers.
3. Compatibility impact statement.

