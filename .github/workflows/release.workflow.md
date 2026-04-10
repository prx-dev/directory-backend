---
name: Release
description: Workflow for preparing and executing a release
trigger: manual
agents:
  - Project Manager
  - Security Reviewer
  - API Reviewer
  - Developer
  - DevOps Engineer
---

# Release Workflow

## Purpose

Coordinates the full release process for the **directory-backend** microservice,
from preparation through deployment and verification.

## Workflow Steps

### Step 1: Release Planning
**Agent**: Project Manager
**Action**: Define release scope and checklist

```
#runSubagent agentName="Project Manager"
"Prepare release plan for version [X.Y.Z].
Define scope, changelog, and quality gate requirements."
```

---

### Step 2: Security Audit
**Agent**: Security Reviewer
**Action**: Pre-release security scan

```
#runSubagent agentName="Security Reviewer"
"Perform pre-release security audit. Scan dependencies for CVEs
and verify no sensitive data in codebase."
```

---

### Step 3: API Contract Validation
**Agent**: API Reviewer
**Action**: Validate all API contracts

```
#runSubagent agentName="API Reviewer"
"Validate all API contracts for the release.
Ensure index.yaml is consistent with all *Api.java interfaces."
```

---

### Step 4: Full Build Verification
**Agent**: Developer

```bash
# Full CI-aligned verification
mvn -B -V -e clean verify

# Verify coverage
mvn clean test jacoco:report
```

---

### Step 5: Release Execution
**Agent**: DevOps Engineer

```bash
# Tag release
git tag -a v[X.Y.Z] -m "Release [X.Y.Z]"
git push origin v[X.Y.Z]

# Build and publish
mvn -DskipTests deploy

# Docker build and push
docker build -t directory-backend:[X.Y.Z] .
```

---

### Step 6: Post-Release Verification
**Agent**: Project Manager

- Verify deployment health
- Validate actuator endpoints
- Run smoke tests
- Update CHANGELOG.md

## Release Checklist

- [ ] All CI workflows pass
- [ ] JaCoCo >= 80% line coverage
- [ ] PMD clean
- [ ] SonarCloud quality gate passed
- [ ] No critical/high CVEs
- [ ] OpenAPI spec up to date
- [ ] CHANGELOG.md updated
- [ ] Release notes prepared
- [ ] Git tag created
- [ ] Artifact published
- [ ] Docker image built
- [ ] Post-deploy verification passed
