---
name: Security Audit
description: Workflow for comprehensive security assessment
trigger: manual
agents:
  - Security Reviewer
  - Developer
  - Project Manager
---

# Security Audit Workflow

## Purpose

Performs a comprehensive security assessment of the **directory-backend** microservice
including dependency scanning, code review, and configuration audit.

## Workflow Steps

### Step 1: Dependency Scan
**Agent**: Security Reviewer
**Action**: Scan all dependencies for known CVEs

```
#runSubagent agentName="Security Reviewer"
"Perform a full dependency vulnerability scan on the directory-backend project.
Check all Maven dependencies for CVEs and report findings."
```

**Output**: CVE report with severity ratings

---

### Step 2: Code Security Review
**Agent**: Security Reviewer
**Action**: Review code for OWASP Top 10 vulnerabilities

```
#runSubagent agentName="Security Reviewer"
"Review the codebase for OWASP Top 10 vulnerabilities.
Focus on: authentication (JWT), input validation, SQL injection,
sensitive data exposure, and security misconfiguration."
```

**Output**: Security findings report

---

### Step 3: Remediation
**Agent**: Developer
**Action**: Fix identified vulnerabilities

```
#runSubagent agentName="Developer"
"Remediate the following security findings:
[paste security findings]
Prioritize critical and high severity items."
```

**Output**: Security fixes

---

### Step 4: Release Assessment
**Agent**: Project Manager
**Action**: Assess release readiness from security perspective

```
#runSubagent agentName="Project Manager"
"Assess release readiness based on the security audit results.
Verify all critical/high findings are resolved or have accepted mitigations."
```

**Output**: Security gate pass/fail determination

## Exit Criteria

- [ ] All dependencies scanned for CVEs
- [ ] No unmitigated critical/high vulnerabilities
- [ ] OWASP Top 10 review completed
- [ ] Sensitive files audit passed
- [ ] Security gate approved for release
