---
name: Code Review
description: Workflow for comprehensive code review process
trigger: pull-request
agents:
  - Code Reviewer
  - API Reviewer
  - Security Reviewer
---

# Code Review Workflow

## Purpose

Orchestrates a comprehensive code review process for pull requests in the
**directory-backend** repository.

## Workflow Steps

### Step 1: Automated Quality Checks
**Prerequisite**: CI pipeline passes

```bash
# Verify locally before requesting review
mvn -B -V -e clean verify
```

---

### Step 2: Code Quality Review
**Agent**: Code Reviewer
**Action**: Review for code quality and conventions

```
#runSubagent agentName="Code Reviewer"
"Review the PR changes for:
- Project convention compliance (thin controllers, service ResponseEntity pattern)
- Java 21 best practices
- Spring Boot best practices
- Code duplication and complexity
- Proper error handling and logging"
```

---

### Step 3: API Contract Review (if API changes)
**Agent**: API Reviewer
**Condition**: Changes include `*Api.java` or `index.yaml`

```
#runSubagent agentName="API Reviewer"
"Review API contract changes for consistency and backward compatibility."
```

---

### Step 4: Security Review (if security-sensitive changes)
**Agent**: Security Reviewer
**Condition**: Changes include auth, crypto, config, or new dependencies

```
#runSubagent agentName="Security Reviewer"
"Review security-sensitive changes for vulnerabilities."
```

---

### Step 5: Merge Decision

**Approval criteria**:
- Code review: APPROVED
- API review (if applicable): PASSED
- Security review (if applicable): PASSED
- CI: All green

## Exit Criteria

- [ ] All applicable reviews completed
- [ ] No unresolved critical/blocking comments
- [ ] CI pipeline passes
- [ ] Coverage thresholds maintained
