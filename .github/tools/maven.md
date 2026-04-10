# Tool: Maven

Purpose

- Build, test, and package the Java Spring Boot application.

Common commands

- Full CI-aligned build (skip tests):

  mvn -DskipTests package

- Full CI-aligned check (same as pipeline):

  mvn -B -V -e clean verify

- Run tests:

  mvn test

- Run a single test class or method:

  mvn -Dtest=com.prx.directory.api.v1.controller.CampaignControllerTest test
  mvn -Dtest=CampaignControllerTest#listCampaignsReturnsOk test

- Generate JaCoCo coverage report:

  mvn clean test jacoco:report

Notes

- Use the project's `mvnw` wrapper to ensure consistent Maven version across environments.
- CI enforces JaCoCo and PMD checks; run `mvn pmd:check` locally to pre-empt failures.

