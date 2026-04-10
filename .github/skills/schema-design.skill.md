---
name: Schema Design
description: Skill for additive schema evolution and relational data modeling
applies-to:
  - Database Architect
---

# Schema Design Skill

## Scope

This skill covers relational schema planning for **directory-backend** with focus
on safe evolution and compatibility.

## Core Practices

- Model entities and relationships to match domain invariants.
- Prefer additive migrations for backward-compatible rollout.
- Define constraints and indexes that support real query patterns.
- Keep naming and types consistent across JPA entities and database schema.

## Project Guardrails

- Preserve existing API behavior while evolving storage shape.
- Validate compatibility with both PostgreSQL (prod) and H2 (tests).
- Coordinate schema changes with repository and service updates.

## Outputs

1. Schema change proposal with migration order.
2. Impact analysis on entities, repositories, and APIs.
3. Validation checklist for test and production environments.

