# Workflow: Release Preparation

Purpose

- Ensure a release meets quality gates, documentation, and readiness criteria.

Participants

- pm-agent (Release Coordinator)
- sec-agent (Dependency Auditor)
- test-agent (Coverage Verifier)
- dev-agent (Fixer)

Steps

1. PM agent collects open PRs and verifies CI status.
2. Run full CI locally: `mvn -B -V -e clean verify`.
3. Generate JaCoCo report and confirm coverage >= 80%.
4. Run PMD and other static checks.
5. Update `CHANGELOG.md` and OpenAPI `src/main/resources/api/index.yaml` if needed.
6. Create release candidate tag and open release notes draft.
7. Coordinate rollout and rollback plan.

Outputs

- Release candidate artifact `directory-backend.jar`
- Release notes and changelog
- Rollout strategy

