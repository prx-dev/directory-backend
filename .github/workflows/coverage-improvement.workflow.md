---
name: Coverage Improvement
description: Workflow for improving test coverage to meet quality gates
trigger: manual
agents:
  - QA / Test Writer
  - Developer
  - Project Manager
---

# Coverage Improvement Workflow

## Purpose

Systematically improves test coverage in the **directory-backend** project
to meet or exceed the JaCoCo quality gate thresholds (80% line, 50% branch).

## Workflow Steps

### Step 1: Coverage Analysis
**Agent**: QA / Test Writer
**Action**: Identify coverage gaps

```bash
# Generate current coverage report
mvn clean test jacoco:report
# Analyze: target/site/jacoco/index.html
```

```
#runSubagent agentName="QA / Test Writer"
"Analyze current JaCoCo coverage report and identify the top 5
classes/packages with the lowest coverage. Prioritize service
and controller classes."
```

---

### Step 2: Write Missing Tests
**Agent**: QA / Test Writer
**Action**: Create tests for uncovered code

```
#runSubagent agentName="QA / Test Writer"
"Write tests for the following uncovered classes:
[list from Step 1]
Target: bring overall line coverage above 80%."
```

---

### Step 3: Implementation Support (if needed)
**Agent**: Developer
**Condition**: If code is untestable and needs refactoring

```
#runSubagent agentName="Developer"
"The following code is difficult to test. Suggest minimal refactoring
to improve testability without changing public behavior."
```

---

### Step 4: Verify Thresholds
**Agent**: Project Manager

```bash
mvn -B -V -e clean verify
```

## Coverage Targets

- Bundle LINE coverage: >= 80%
- Package BRANCH coverage: >= 50%
- Focus areas (highest impact):
  - Service implementations (`*ServiceImpl.java`)
  - Controller tests (`*Controller.java`)
  - Mapper tests (`*Mapper.java`)
  - Utility classes (`JwtUtil`, filter parsers)

## Exit Criteria

- [ ] Line coverage >= 80% at bundle level
- [ ] Branch coverage >= 50% at package level
- [ ] All new tests follow project conventions
- [ ] Full build passes: `mvn -B -V -e clean verify`
