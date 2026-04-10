---
name: SQL Optimization
description: Skill for tuning SQL access patterns and reducing database performance bottlenecks
applies-to:
  - Database Architect
---

# SQL Optimization Skill

## Scope

This skill targets query performance improvements for **directory-backend** while
preserving business behavior.

## Core Practices

- Analyze slow or high-frequency query paths.
- Propose indexing strategies based on filter/sort usage.
- Mitigate N+1 patterns and unnecessary fetch breadth.
- Validate tuning changes with representative test scenarios.

## Project Guardrails

- Prefer JPA specification and repository-level optimizations before native SQL.
- Keep performance changes backward compatible for `/api/v1/*` responses.
- Ensure H2 compatibility for automated tests.

## Outputs

1. Query bottleneck report.
2. Optimization proposal with expected impact.
3. Verification plan for correctness and performance.

