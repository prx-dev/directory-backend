---
name: Backlog Management
description: Skill for managing product backlog and user stories
applies-to:
  - Product Owner
  - Project Manager
  - Repo Requirements Analyst
---

# Backlog Management Skill

## Scope

This skill covers product backlog management, user story creation, and prioritization
for the **directory-backend** project.

## User Story Template

```markdown
### [STORY-XXX] Title

**As a** [role],
**I want to** [capability],
**So that** [business value].

#### Acceptance Criteria

```gherkin
Given [precondition]
When [action]
Then [expected result]
```

#### Technical Notes
- Affected endpoints: [list]
- DTOs: [list]
- Entities: [list]

#### Priority: P0/P1/P2
#### Effort: S/M/L
#### Dependencies: [list]
```

## Priority Framework

- **P0 (Critical)**: Security vulnerabilities, data corruption, production outages
- **P1 (High)**: Core feature delivery, backward compatibility, coverage gaps
- **P2 (Medium)**: Performance improvements, developer experience, documentation
- **P3 (Low)**: Nice-to-have features, cosmetic changes, tech debt

## Domain Areas

- **User Management**: Registration, profile, authentication
- **Business Directory**: CRUD, product linking, search
- **Campaigns**: Full lifecycle with filtering/sorting
- **Commerce**: Products, categories, favorites
- **Platform**: Timezones, digital contacts, notifications
