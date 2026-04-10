---
name: JWT Security
description: Skill for reviewing JWT creation, validation, and lifecycle security controls
applies-to:
  - Security Reviewer
---

# JWT Security Skill

## Scope

This skill focuses on JWT security in **directory-backend**, especially around
`SessionJwtServiceImpl`, `AuthServiceImpl`, and `JwtUtil` flows.

## Core Practices

- Validate token signing strategy, expiration, and claim integrity.
- Confirm clock-skew and replay risks are handled appropriately.
- Ensure token parsing failures are safe and do not leak sensitive details.
- Verify secrets and signing keys are externally managed.

## Project Guardrails

- Never hardcode signing material in source, configs, or tests.
- Keep auth changes backward compatible with existing clients unless approved.
- Preserve expected status/header behavior for auth endpoints.

## Outputs

1. JWT threat checklist and findings.
2. Remediation recommendations with priority.
3. Verification steps for regression-safe hardening.

