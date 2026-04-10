# AI Agents - Overview

This directory contains agent profiles used for delivery, implementation, review, and quality workflows in `directory-backend`.

## Agent Files and Assigned Skills

| Agent File | Agent Name | Assigned Skills (from front matter `skills`) |
|---|---|---|
| `api-reviewer.agent.md` | API Reviewer | `openapi-specification`, `rest-api-design`, `api-contract-review` |
| `code-reviewer.agent.md` | Code Reviewer | `java-spring-development`, `java-code-quality`, `spring-boot-best-practices`, `clean-code`, `pmd-analysis` |
| `database-architect.agent.md` | Database Architect | `jpa-persistence`, `sql-optimization`, `schema-design`, `spring-data-jpa` |
| `developer.agent.md` | Developer | `java-spring-development`, `rest-api-design`, `jpa-persistence`, `mapstruct-mapping`, `feign-integration`, `kafka-messaging`, `api-contract-review`, `junit5-testing` |
| `devops-engineer.agent.md` | DevOps Engineer | `release-management`, `ci-cd-orchestration`, `docker-containerization`, `github-actions`, `maven-build` |
| `product-owner.agent.md` | Product Owner | `api-contract-review`, `acceptance-criteria`, `openapi-specification`, `backlog-management`, `rest-api-design` |
| `project-manager.agent.md` | Project Manager | `release-management`, `risk-assessment`, `ci-cd-orchestration`, `quality-gates`, `sprint-planning`, `backlog-management`, `jacoco-coverage` |
| `repo-requirements-analyst.agent.md` | Repo Requirements Analyst | `backlog-management`, `acceptance-criteria`, `risk-assessment` |
| `security-reviewer.agent.md` | Security Reviewer | `cve-detection`, `dependency-audit`, `owasp-top10`, `jwt-security`, `spring-security` |
| `test-writer.agent.md` | QA / Test Writer | `junit5-testing`, `mockito-mocking`, `spring-boot-testing`, `jacoco-coverage`, `test-design-patterns` |

## Collaboration Model

- Agents collaborate through issues, pull requests, and CI workflows.
- Agent outputs should include actionable artifacts (code, tests, docs, and review notes).
- Human reviewers remain responsible for approval and merge decisions.

## Shared Constraints

- Follow repository conventions in `AGENTS.md` and `CLAUDE.md`.
- Preserve backward compatibility for `/api/v1/*` unless a request explicitly allows breaking changes.
- Never commit secrets or modify certificate/keystore files unless explicitly requested.
