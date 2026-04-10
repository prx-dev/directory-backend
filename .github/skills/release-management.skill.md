---
name: Release Management
description: Skill for coordinating releases and quality gates
applies-to:
  - Project Manager
  - DevOps Engineer
---

# Release Management Skill

## Scope

This skill covers release coordination, quality gate validation, and deployment
processes for the **directory-backend** project.

## Quality Gates

### Required Before Release

1. **CI Pipeline** — All three workflows must pass:
   - `ci.yml` (SonarCloud): build + test + JaCoCo upload
   - `build.yml` (SonarQube): build + Sonar analysis
   - `qodana_code_quality.yml`: Qodana static analysis

2. **Coverage** — JaCoCo thresholds met:
   - Bundle: 80% line coverage
   - Package: 50% branch coverage

3. **Static Analysis** — No violations:
   - PMD: priority <= 5
   - SonarCloud quality gate: passed
   - Qodana: no critical issues

4. **Security** — Dependency audit:
   - No critical/high CVEs unmitigated
   - Secrets scan clean

5. **Documentation** — Updated:
   - CHANGELOG.md
   - OpenAPI spec (`index.yaml`)
   - README if user-facing changes

## Release Process

1. Create release branch from `development`
2. Run full verification: `mvn -B -V -e clean verify`
3. Security audit via **Security Reviewer** subagent
4. API contract review via **API Reviewer** subagent
5. Merge to `main` via PR
6. Tag release version
7. Publish artifact to Repsy repository
8. Build and push Docker image
9. Deploy and verify

## Versioning

Current: `0.0.1` (pre-release)
Follow semantic versioning: `MAJOR.MINOR.PATCH`
