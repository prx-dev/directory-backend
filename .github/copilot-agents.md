# AI Agent Coworkers — directory-backend

This document indexes all AI agents, skills, tools, and workflows configured
for the **directory-backend** Spring Boot microservice.

## Agents

### Primary Agents (User-Invocable)

| Agent | File | Description |
|-------|------|-------------|
| Developer | `agents/developer.agent.md` | Senior full-stack developer (Java/Spring) |
| QA / Test Writer | `agents/test-writer.agent.md` | Automated test authoring |
| Product Owner | `agents/product-owner.agent.md` | Business stakeholder / requirements |
| Project Manager | `agents/project-manager.agent.md` | Delivery lead / release coordination |
| Repo Requirements Analyst | `agents/repo-requirements-analyst.agent.md` | Codebase analysis / requirement discovery |

### Subagents (Agent-Invocable Only)

| Agent | File | Description |
|-------|------|-------------|
| API Reviewer | `agents/api-reviewer.agent.md` | OpenAPI contract validation |
| Security Reviewer | `agents/security-reviewer.agent.md` | CVE scanning / OWASP review |
| Code Reviewer | `agents/code-reviewer.agent.md` | Code quality / convention compliance |
| Database Architect | `agents/database-architect.agent.md` | JPA entity design / query optimization |
| DevOps Engineer | `agents/devops-engineer.agent.md` | CI/CD pipeline / Docker management |

## Skills

| Skill | File | Used By |
|-------|------|---------|
| Acceptance Criteria | `skills/acceptance-criteria.skill.md` | Product Owner, Repo Requirements Analyst |
| API Contract Review | `skills/api-contract-review.skill.md` | API Reviewer, Product Owner, Developer |
| Backlog Management | `skills/backlog-management.skill.md` | Product Owner, Project Manager, Repo Requirements Analyst |
| CI/CD Orchestration | `skills/ci-cd-orchestration.skill.md` | Project Manager, DevOps Engineer |
| Clean Code | `skills/clean-code.skill.md` | Code Reviewer |
| CVE Detection | `skills/cve-detection.skill.md` | Security Reviewer |
| Dependency Audit | `skills/dependency-audit.skill.md` | Security Reviewer |
| Docker Containerization | `skills/docker-containerization.skill.md` | DevOps Engineer |
| Feign Integration | `skills/feign-integration.skill.md` | Developer |
| GitHub Actions | `skills/github-actions.skill.md` | DevOps Engineer |
| JaCoCo Coverage | `skills/jacoco-coverage.skill.md` | QA / Test Writer, Project Manager |
| Java Code Quality | `skills/java-code-quality.skill.md` | Code Reviewer |
| Java Spring Development | `skills/java-spring-development.skill.md` | Developer, Code Reviewer |
| JPA Persistence | `skills/jpa-persistence.skill.md` | Developer, Database Architect |
| JUnit 5 Testing | `skills/junit5-testing.skill.md` | QA / Test Writer, Developer |
| JWT Security | `skills/jwt-security.skill.md` | Security Reviewer |
| Kafka Messaging | `skills/kafka-messaging.skill.md` | Developer |
| MapStruct Mapping | `skills/mapstruct-mapping.skill.md` | Developer |
| Maven Build | `skills/maven-build.skill.md` | DevOps Engineer |
| Mockito Mocking | `skills/mockito-mocking.skill.md` | QA / Test Writer |
| OpenAPI Specification | `skills/openapi-specification.skill.md` | Product Owner, API Reviewer |
| OWASP Top 10 | `skills/owasp-top10.skill.md` | Security Reviewer |
| PMD Analysis | `skills/pmd-analysis.skill.md` | Code Reviewer |
| Quality Gates | `skills/quality-gates.skill.md` | Project Manager |
| Release Management | `skills/release-management.skill.md` | Project Manager, DevOps Engineer |
| REST API Design | `skills/rest-api-design.skill.md` | Developer, API Reviewer, Product Owner |
| Risk Assessment | `skills/risk-assessment.skill.md` | Project Manager, Repo Requirements Analyst |
| Schema Design | `skills/schema-design.skill.md` | Database Architect |
| Spring Boot Best Practices | `skills/spring-boot-best-practices.skill.md` | Code Reviewer |
| Spring Boot Testing | `skills/spring-boot-testing.skill.md` | QA / Test Writer |
| Spring Data JPA | `skills/spring-data-jpa.skill.md` | Database Architect |
| Spring Security | `skills/spring-security.skill.md` | Security Reviewer |
| Sprint Planning | `skills/sprint-planning.skill.md` | Project Manager |
| SQL Optimization | `skills/sql-optimization.skill.md` | Database Architect |
| Test Design Patterns | `skills/test-design-patterns.skill.md` | QA / Test Writer |

## Tools

| Tool | File | Type |
|------|------|------|
| Maven Build | `tools/maven-build.tool.md` | Terminal |
| Docker Build | `tools/docker-build.tool.md` | Terminal |
| GitHub CLI | `tools/github-cli.tool.md` | Terminal |
| Dependency Check | `tools/dependency-check.tool.md` | Terminal |
| OpenAPI Validator | `tools/openapi-validator.tool.md` | Terminal |
| Sonar Analysis | `tools/sonar-analysis.tool.md` | Terminal |

## Workflows

| Workflow | File | Trigger | Agents Involved |
|----------|------|---------|-----------------|
| Feature Development | `workflows/feature-development.workflow.md` | Manual | PO, Dev, QA, API Rev, Code Rev |
| Bug Fix | `workflows/bug-fix.workflow.md` | Manual | Dev, QA, Code Rev |
| Security Audit | `workflows/security-audit.workflow.md` | Manual | Sec Rev, Dev, PM |
| Code Review | `workflows/code-review.workflow.md` | Pull Request | Code Rev, API Rev, Sec Rev |
| Release | `workflows/release.workflow.md` | Manual | PM, Sec Rev, API Rev, Dev, DevOps |
| Coverage Improvement | `workflows/coverage-improvement.workflow.md` | Manual | QA, Dev, PM |

## Agent Collaboration Map

```
                    ┌──────────────────┐
                    │  Project Manager │
                    └────────┬─────────┘
                             │ coordinates
              ┌──────────────┼──────────────┐
              ▼              ▼              ▼
     ┌─────────────┐ ┌────────────┐ ┌──────────────┐
     │Product Owner│ │  Developer │ │QA/Test Writer│
     └──────┬──────┘ └─────┬──────┘ └──────┬───────┘
            │               │               │
            │  requirements │ implementation│ tests
            │               │               │
            ▼               ▼               ▼
     ┌──────────────────────────────────────────┐
     │              Subagents                    │
     │                                           │
     │  ┌─────────────┐  ┌──────────────────┐   │
     │  │API Reviewer  │  │Security Reviewer │   │
     │  └─────────────┘  └──────────────────┘   │
     │  ┌─────────────┐  ┌──────────────────┐   │
     │  │Code Reviewer │  │Database Architect│   │
     │  └─────────────┘  └──────────────────┘   │
     │  ┌──────────────────┐                     │
     │  │ DevOps Engineer  │                     │
     │  └──────────────────┘                     │
     └──────────────────────────────────────────┘
```

## Quick Start

1. **New feature**: Use the [Feature Development Workflow](workflows/feature-development.workflow.md)
2. **Bug fix**: Use the [Bug Fix Workflow](workflows/bug-fix.workflow.md)
3. **Pre-release**: Use the [Release Workflow](workflows/release.workflow.md)
4. **Coverage gap**: Use the [Coverage Improvement Workflow](workflows/coverage-improvement.workflow.md)
5. **Security check**: Use the [Security Audit Workflow](workflows/security-audit.workflow.md)
