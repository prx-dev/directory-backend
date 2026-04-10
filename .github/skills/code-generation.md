# Skill: Code Generation

Purpose

- Produce, modify, and refactor source code following repository conventions and best practices.

Inputs

- Issue or feature description
- Relevant files or modules to edit
- Coding conventions (see `AGENTS.md`, `CLAUDE.md`)

Outputs

- Java source files, MapStruct mappers, DTOs, and tests
- PR description and test run results

Preconditions

- Developer agent or human provides acceptance criteria
- CI tests available for validation

Typical steps

1. Analyze existing code and find relevant modules/entry points.
2. Create minimal, atomic changes in a feature branch.
3. Run unit tests locally and adjust until green.
4. Open PR with detailed description and JIRA/issue link.
5. Add or update documentation and OpenAPI if API changes.

