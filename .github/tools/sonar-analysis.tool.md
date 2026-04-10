---
name: Sonar Analysis
description: Tool for SonarCloud/SonarQube static analysis
type: terminal
command-prefix: mvn
---

# Sonar Analysis Tool

## Purpose

Run SonarCloud/SonarQube static analysis on the **directory-backend** project.

## Configuration

- **Organization**: umdevc
- **Project Key**: umdc-directory-backend
- **Project Name**: umdc-directory-backend
- **Host URL**: https://sonarcloud.io

## Commands

### Run Sonar Analysis

```bash
# Full build + Sonar analysis (requires SONAR_TOKEN)
mvn -B verify org.sonarsource.scanner.maven:sonar-maven-plugin:sonar \
  -Dsonar.projectKey=umdc-directory-backend

# With explicit token
mvn -B verify org.sonarsource.scanner.maven:sonar-maven-plugin:sonar \
  -Dsonar.projectKey=umdc-directory-backend \
  -Dsonar.token=$SONAR_TOKEN
```

### Sonar Properties

Configured in `pom.xml`:
- `sonar.inclusions`: `src/main/java/**/*.java`
- `sonar.exclusions`: XML, Application, exceptions, util, config, mapper, test, cache, security, producer, interceptor
- `sonar.coverage.jacoco.xmlReportPaths`: `/site/jacoco/jacoco.xml`

### View Results

Visit: `https://sonarcloud.io/project/overview?id=umdc-directory-backend`
