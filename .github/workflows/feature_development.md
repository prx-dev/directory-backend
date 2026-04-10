# Workflow: Feature Development

Purpose

- Guide agents through implementing a small-to-medium feature while preserving repository conventions.

Participants

- dev-agent (Feature Implementer)
- test-agent (Unit Test Writer)
- pm-agent (Release Coordinator)
- sec-agent (Security Auditor)

Steps

1. Issue triage: pm-agent confirms acceptance criteria and constraints.
2. Branch creation: dev-agent creates `feature/<short-desc>` branch.
3. Implementation: dev-agent adds code and mapstruct mappers following patterns.
4. Tests: test-agent writes unit + integration tests; runs `mvn test` and `mvn clean test jacoco:report`.
5. Security review: sec-agent runs dependency scanner and static analyzers.
6. PR: dev-agent opens PR with checklist and links to CI results.
7. Review & merge: humans review and merge when CI green.

Outputs

- PR with code, tests, and updated docs
- CI green with coverage report attached

