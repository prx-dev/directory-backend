---
name: Java Spring Development
description: Core skill for developing Java 21 Spring Boot 3.5.x microservices
applies-to:
  - Developer
  - Code Reviewer
---

# Java Spring Development Skill

## Scope

This skill covers Java 21 and Spring Boot 3.5.8 development patterns used in the
**directory-backend** microservice.

## Java 21 Patterns

### Records for DTOs
```java
public record CampaignTO(
    UUID id,
    String title,
    String description,
    Instant startDate,
    Instant endDate,
    UUID categoryId,
    UUID businessId,
    Boolean active,
    Instant createdDate,
    Instant lastUpdate
) {}
```

### Pattern Matching
```java
if (obj instanceof CampaignEntity campaign) {
    return campaign.getTitle();
}
```

### Sealed Classes (where applicable)
```java
public sealed interface ApiResponse permits SuccessResponse, ErrorResponse {}
```

## Spring Boot 3.5.8 Patterns

### Controller Pattern (Thin)
```java
@RestController
@RequestMapping("/api/v1/campaigns")
public class CampaignController implements CampaignApi {
    private final CampaignService campaignService;

    public CampaignController(CampaignService campaignService) {
        this.campaignService = campaignService;
    }

    @Override
    public CampaignService getService() {
        return campaignService;
    }
}
```

### Service Pattern (Business Logic + ResponseEntity)
```java
@Service
public class CampaignServiceImpl implements CampaignService {
    @Override
    @Transactional
    public ResponseEntity<CampaignTO> create(CampaignTO campaignTO) {
        // Validation
        // Entity mapping
        // Repository save
        // Return ResponseEntity with appropriate status
    }
}
```

### Repository Pattern
```java
public interface CampaignRepository extends JpaRepository<CampaignEntity, UUID>,
                                            JpaSpecificationExecutor<CampaignEntity> {}
```

### MapStruct Mapper Pattern
```java
@Mapper(config = MapperAppConfig.class)
public interface CampaignMapper {
    CampaignTO toTO(CampaignEntity entity);
    CampaignEntity toEntity(CampaignTO to);
}
```

## Dependency Injection

- **Always use constructor injection** (no `@Autowired` on fields).
- Spring will auto-inject when there is a single constructor.
- Use `@Qualifier` only when multiple beans of the same type exist.

## Error Handling

```java
throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
    DirectoryAppConstants.CAMPAIGN_CATEGORY_ID_REQUIRED);
```

## Response Headers

```java
HttpHeaders headers = new HttpHeaders();
headers.add(DirectoryAppConstants.MESSAGE_HEADER, "Operation successful");
return new ResponseEntity<>(body, headers, HttpStatus.OK);
```
