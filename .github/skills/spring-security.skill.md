---
name: Spring Security
description: Skill for securing endpoints, auth flows, and configuration in Spring services
applies-to:
  - Security Reviewer
---

# Spring Security Skill

## Scope

This skill reviews endpoint security posture in **directory-backend**, including
authentication, authorization, and secure configuration defaults.

## Core Practices

- Verify protected endpoint boundaries and role checks.
- Confirm security filters and token processing fail closed.
- Review CORS, error handling, and exposure of sensitive details.
- Ensure secrets and credentials are sourced from secure external configuration.

## Project Guardrails

- Keep auth behavior consistent with existing clients unless approved changes are requested.
- Preserve secure defaults in all environments.
- Avoid committing security-sensitive material to source control.

## Outputs

1. Security configuration review notes.
2. Prioritized hardening recommendations.
3. Regression test suggestions for auth-sensitive routes.

