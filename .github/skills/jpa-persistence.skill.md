---
name: JPA Persistence
description: Skill for Spring Data JPA, entity design, specifications, and repository patterns
applies-to:
  - Developer
  - Database Architect
---

# JPA Persistence Skill

## Scope

This skill covers Spring Data JPA patterns, entity design, JPA Specifications for
dynamic queries, and repository patterns in the **directory-backend** project.

## Entity Design Pattern

```java
@Entity
@Table(name = "campaign")
public class CampaignEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, length = 2500)
    private String title;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_fk", nullable = false)
    private CategoryEntity category;

    @Column(name = "created_date", updatable = false)
    private Instant createdDate;

    @Column(name = "last_update")
    private Instant lastUpdate;
    // getters/setters
}
```

## Composite Key Pattern

```java
@Embeddable
public class BusinessProductEntityId implements Serializable {
    @Column(name = "business_id")
    private UUID businessId;
    @Column(name = "product_id")
    private UUID productId;
    // equals, hashCode
}
```

## JPA Specification Pattern

```java
public class CampaignSpecifications {
    public static Specification<CampaignEntity> titleContains(String title) {
        return (root, query, cb) ->
            cb.like(cb.lower(root.get("title")), "%" + title.toLowerCase() + "%");
    }

    public static Specification<CampaignEntity> hasCategory(UUID categoryId) {
        return (root, query, cb) ->
            cb.equal(root.get("category").get("id"), categoryId);
    }
}
```

Specifications are composed dynamically by `CampaignFilterParser`:
```java
Specification<CampaignEntity> spec = Specification.where(null);
if (criteria.title() != null) spec = spec.and(titleContains(criteria.title()));
if (criteria.categoryId() != null) spec = spec.and(hasCategory(criteria.categoryId()));
```

## Optimistic Locking Pattern

`CampaignServiceImpl.update()` checks `lastUpdate` timestamp:
- If the client's `lastUpdate` matches the DB value, apply update -> `202 Accepted`
- If mismatched, reject with `409 Conflict`

## Repository Pattern

Extend both `JpaRepository` and `JpaSpecificationExecutor` for dynamic query support:
```java
public interface CampaignRepository extends
    JpaRepository<CampaignEntity, UUID>,
    JpaSpecificationExecutor<CampaignEntity> {}
```
