---
name: Docker Containerization
description: Skill for building secure, efficient Docker images for the service
applies-to:
  - DevOps Engineer
---

# Docker Containerization Skill

## Scope

This skill covers container build and runtime hardening practices for
**directory-backend**.

## Core Practices

- Keep Docker images minimal and reproducible.
- Use multi-stage builds where helpful to reduce runtime size.
- Ensure Java runtime settings and exposed ports match application behavior.
- Validate image startup with expected environment variables.

## Project Guardrails

- Do not bake secrets, certificates, or keystores into custom layers unless explicitly required.
- Keep runtime config externalized (Vault/Config Server/bootstrap-first model).
- Verify image changes do not alter `/api/v1/*` contract behavior.

## Outputs

1. Dockerfile improvement notes or patches.
2. Image build and smoke-test checklist.
3. Security hardening recommendations.

