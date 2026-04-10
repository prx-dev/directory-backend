---
name: Acceptance Criteria
description: Skill for defining clear, testable acceptance criteria for directory-backend work
applies-to:
  - Product Owner
  - Repo Requirements Analyst
---

# Acceptance Criteria Skill

## Scope

This skill defines business-ready acceptance criteria for features and fixes in
**directory-backend**, with emphasis on testability and API contract clarity.

## Core Practices

- Write criteria in Given/When/Then format.
- Include both happy-path and failure scenarios.
- Specify HTTP status, response shape, and required headers when API behavior changes.
- Add concrete payload examples for request and response bodies.

## Project Guardrails

- Preserve `/api/v1/*` backward compatibility unless explicitly approved.
- Keep legacy campaign aliases (`q`, `category_id`, `business_id`, `start_date_*`, `end_date_*`) documented when relevant.
- Align messages and headers with `DirectoryAppConstants` semantics.
- If contract behavior changes, ensure both `*Api.java` and `src/main/resources/api/index.yaml` are updated.

## Outputs

1. User story and acceptance criteria set.
2. Example JSON payloads and status matrix.
3. Traceability notes linking criteria to tests and OpenAPI sections.

