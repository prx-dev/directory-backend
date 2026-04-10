---
name: JUnit 5 Testing
description: Skill for JUnit 5 and Mockito test patterns
applies-to:
  - QA / Test Writer
  - Developer
---

# JUnit 5 Testing Skill

## Scope

This skill covers JUnit 5 + Mockito test patterns, Spring Boot test utilities,
and coverage strategies for the **directory-backend** project.

## Test Dependencies

- JUnit Jupiter 5.14.1
- Mockito 5.21.0
- Spring Boot Test (managed)
- Spring REST Docs MockMvc
- H2 Database (test scope)
- JMH 1.37 (benchmarks)

## Test Annotations

### Unit Tests (Preferred)
```java
@ExtendWith(MockitoExtension.class)
@DisplayName("CampaignServiceImpl Unit Tests")
class CampaignServiceImplTest {
    @Mock CampaignRepository campaignRepository;
    @InjectMocks CampaignServiceImpl service;
}
```

### Controller Tests
```java
@WebMvcTest(CampaignController.class)
@DisplayName("CampaignController MVC Tests")
class CampaignControllerTest {
    @Autowired MockMvc mockMvc;
    @MockBean CampaignService campaignService;
}
```

### Repository Integration Tests
```java
@DataJpaTest
@ActiveProfiles("test")
@DisplayName("CampaignRepository Integration Tests")
class CampaignRepositoryTest {
    @Autowired CampaignRepository repository;
    @Autowired TestEntityManager entityManager;
}
```

## Test Method Patterns

### Arrange / Act / Assert
```java
@Test
@DisplayName("Should throw 400 when categoryId is null")
void create_throwsBadRequest_whenCategoryIdNull() {
    // Arrange
    var request = new CampaignTO(null, "title", "desc", null, null, null, null, true, null, null);
    // Act & Assert
    assertThatThrownBy(() -> service.create(request))
        .isInstanceOf(ResponseStatusException.class)
        .hasFieldOrPropertyWithValue("status", HttpStatus.BAD_REQUEST);
}
```

### Parameterized Tests
```java
@ParameterizedTest
@ValueSource(strings = {"stores", "products", "offers"})
@DisplayName("Should accept valid favorite types")
void favorites_acceptsValidType(String type) {
    // test each type
}
```

## Coverage Targets

- **Bundle level**: 80% line coverage (JaCoCo)
- **Package level**: 50% branch coverage (JaCoCo)
- Run: `mvn clean test jacoco:report`
- Report: `target/site/jacoco/index.html`
