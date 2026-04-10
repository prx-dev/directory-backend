---
name: OpenAPI Validator
description: Tool for validating OpenAPI specifications
type: terminal
---

# OpenAPI Validator Tool

## Purpose

Validate the OpenAPI specification and ensure consistency between Java API
interfaces and the YAML spec in the **directory-backend** project.

## Spec Location

- `src/main/resources/api/index.yaml`

## Validation Commands

### Using springdoc-openapi Maven Plugin

```bash
# Generate OpenAPI spec from running application
mvn springdoc-openapi:generate

# Output: target/openapi.json
```

### Manual Validation

```bash
# Install spectral (OpenAPI linter)
npm install -g @stoplight/spectral-cli

# Lint the spec
spectral lint src/main/resources/api/index.yaml

# Validate with swagger-cli
npm install -g @apidevtools/swagger-cli
swagger-cli validate src/main/resources/api/index.yaml
```

### Consistency Check Script

To verify Java annotations match the YAML spec:

1. Extract endpoints from `*Api.java` files (grep for `@GetMapping`, `@PostMapping`, etc.)
2. Extract paths from `index.yaml`
3. Compare for mismatches

```bash
# Find all API endpoints in Java
grep -rn '@\(Get\|Post\|Put\|Patch\|Delete\)Mapping' src/main/java/com/prx/directory/api/v1/controller/*Api.java

# Find all paths in OpenAPI spec
grep -E '^  /api/' src/main/resources/api/index.yaml
```

## Key Files

- API interfaces: `src/main/java/com/prx/directory/api/v1/controller/*Api.java`
- OpenAPI spec: `src/main/resources/api/index.yaml`
- DTO records: `src/main/java/com/prx/directory/api/v1/to/*.java`
