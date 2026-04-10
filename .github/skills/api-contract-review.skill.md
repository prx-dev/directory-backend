---
name: API Contract Review
description: Skill for reviewing and validating OpenAPI contracts
applies-to:
  - API Reviewer
  - Product Owner
  - Developer
---

# API Contract Review Skill

## Scope

This skill covers the process of reviewing and validating OpenAPI contracts
for the **directory-backend** project.

## Contract Locations

1. **Java API Interfaces**: `src/main/java/com/prx/directory/api/v1/controller/*Api.java`
   - Swagger/OpenAPI annotations: `@Operation`, `@ApiResponses`, `@Tag`
   - Default method implementations delegating to service layer

2. **OpenAPI Spec**: `src/main/resources/api/index.yaml`
   - Full API specification in OpenAPI 3.0 format
   - Must be kept in sync with Java annotations

## Review Checklist

### Consistency
- Every `*Api.java` endpoint has a matching path in `index.yaml`
- HTTP methods match between code and spec
- Request/response schemas match DTO record definitions
- Status codes in `@ApiResponses` match spec responses

### Backward Compatibility
- No removal of existing fields from response objects
- No changes to existing endpoint paths or methods
- Legacy filter aliases (`q`, `category_id`, etc.) still functional
- Pagination parameters unchanged

### Documentation Quality
- `@Operation(summary, description)` present on all endpoints
- `@ExampleObject` with valid JSON payloads
- `@Parameter` descriptions on all path/query params
- Error responses properly documented

### Security
- Auth requirements documented per endpoint
- Sensitive data not exposed in examples
