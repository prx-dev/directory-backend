---
name: PMD Analysis
description: Skill for analyzing and remediating PMD and CPD quality findings
applies-to:
  - Code Reviewer
---

# PMD Analysis Skill

## Scope

This skill addresses static-analysis review using PMD/CPD signals in
**directory-backend**.

## Core Practices

- Classify PMD findings by severity and merge risk.
- Prioritize correctness and security-related violations first.
- Reduce duplication flagged by CPD where practical.
- Confirm fixes remain behavior-preserving and test-backed.

## Project Guardrails

- Keep remediations minimal and scoped to requested work.
- Maintain service/header conventions while cleaning code.
- Re-run CI-aligned checks after fixes.

## Outputs

1. PMD findings triage list.
2. Proposed remediation set with file-level scope.
3. Verification evidence from re-run analysis.

