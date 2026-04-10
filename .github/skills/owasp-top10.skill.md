---
name: OWASP Top 10
description: Skill for structured OWASP Top 10 risk assessment across API and backend layers
applies-to:
  - Security Reviewer
---

# OWASP Top 10 Skill

## Scope

This skill applies OWASP Top 10 checks to **directory-backend** endpoint handling,
authentication, configuration, and data flows.

## Core Practices

- Review access control and authorization boundaries.
- Check injection defenses in API validation and persistence filters.
- Evaluate cryptographic hygiene for JWT and transport security.
- Verify logging, error handling, and secrets management controls.

## Project Guardrails

- Prioritize findings that impact `/api/v1/*` externally exposed paths.
- Preserve sensitive data protections in logs and responses.
- Respect repository rules for certificate and keystore handling.

## Outputs

1. OWASP category-based findings report.
2. Risk-severity mapping and remediation order.
3. Regression checks for implemented mitigations.

