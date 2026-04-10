---
name: REST API Design
description: Skill for designing and maintaining RESTful APIs with OpenAPI documentation
applies-to:
  - Developer
  - API Reviewer
  - Product Owner
---

# REST API Design Skill

## Scope

This skill covers REST API design principles, OpenAPI specification maintenance,
and API contract patterns used in the **directory-backend** project.

## API Interface Pattern

API contracts are defined in `*Api.java` interfaces with Swagger annotations.
Controllers are thin implementations that delegate to services.

```java
@Tag(name = "campaigns", description = "The Campaign API")
public interface CampaignApi {

    default CampaignService getService() {
        return new CampaignService() {};
    }

    @Operation(summary = "Create a new campaign")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Campaign created"),
        @ApiResponse(responseCode = "400", description = "Validation error"),
        @ApiResponse(responseCode = "404", description = "Related entity not found")
    })
    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    default ResponseEntity<CampaignTO> create(@RequestBody CampaignTO campaignTO) {
        return this.getService().create(campaignTO);
    }
}
```

## HTTP Status Code Conventions

- `200 OK` — Successful read/query
- `201 Created` — Successful resource creation
- `202 Accepted` — Successful update (optimistic lock pattern)
- `204 No Content` — Successful delete
- `400 Bad Request` — Validation failure
- `401 Unauthorized` — Missing/invalid authentication
- `403 Forbidden` — Insufficient permissions
- `404 Not Found` — Resource does not exist
- `409 Conflict` — Optimistic lock conflict
- `500 Internal Server Error` — Unexpected failure

## Pagination Pattern

Query parameters: `page` (1-based), `per_page` (default 10, max 100)

Response wrapper: `PaginatedResponse<T>` or `CampaignListResponse` with metadata.

## Filter and Sort Pattern

Campaign search supports legacy aliases for backward compatibility:
- `q` -> title search (partial, case-insensitive)
- `category_id` -> categoryId filter
- `business_id` -> businessId filter
- `start_date_from` / `start_date_to` -> startDate range
- `end_date_from` / `end_date_to` -> endDate range
- Sort: comma-separated fields with `-` prefix for descending

## OpenAPI Spec Maintenance

When modifying API contracts, ALWAYS update both:
1. `*Api.java` interface annotations
2. `src/main/resources/api/index.yaml`

Verify consistency using the **API Reviewer** subagent.
