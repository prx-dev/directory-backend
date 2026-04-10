---
name: Feature Development
description: End-to-end workflow for developing a new feature
trigger: manual
agents:
  - Product Owner
  - Developer
  - QA / Test Writer
  - API Reviewer
  - Code Reviewer
---

# Feature Development Workflow

## Purpose

Orchestrates the end-to-end process of developing a new feature for the
**directory-backend** microservice, from requirements to merged code.

## Workflow Steps

### Step 1: Requirements Definition
**Agent**: Product Owner
**Action**: Define user story with acceptance criteria

```
#runSubagent agentName="Product Owner"
"Define the user story, acceptance criteria, and OpenAPI contract for [feature description].
Include example JSON payloads and expected HTTP status codes."
```

**Output**: User story with acceptance criteria, OpenAPI fragment

---

### Step 2: Implementation
**Agent**: Developer
**Action**: Implement the feature following project conventions

```
#runSubagent agentName="Developer"
"Implement the feature based on the acceptance criteria:
[paste acceptance criteria]
Follow existing patterns: Api interface -> Controller -> Service -> Repository."
```

**Output**: Production code changes

---

### Step 3: Test Writing
**Agent**: QA / Test Writer
**Action**: Write comprehensive tests for the implementation

```
#runSubagent agentName="QA / Test Writer"
"Write unit and integration tests for the implemented feature.
Cover happy path, validation errors, not-found cases, and edge cases.
Ensure JaCoCo coverage stays above 80% line coverage."
```

**Output**: Test files, coverage report

---

### Step 4: API Contract Review
**Agent**: API Reviewer
**Action**: Validate API contract consistency

```
#runSubagent agentName="API Reviewer"
"Review the API changes for consistency between *Api.java annotations
and index.yaml. Check backward compatibility."
```

**Output**: API review report

---

### Step 5: Code Review
**Agent**: Code Reviewer
**Action**: Review code quality and conventions

```
#runSubagent agentName="Code Reviewer"
"Review the code changes for quality, convention compliance,
and potential issues."
```

**Output**: Code review report with approval status

---

### Step 6: Verification
**Agent**: Developer
**Action**: Run full CI-aligned build

```bash
mvn -B -V -e clean verify
```

**Output**: Green build with all quality gates passing

## Exit Criteria

- [ ] Acceptance criteria met
- [ ] All tests pass
- [ ] JaCoCo coverage >= 80% line
- [ ] PMD clean
- [ ] API contract consistent
- [ ] Code review approved
- [ ] CHANGELOG updated
