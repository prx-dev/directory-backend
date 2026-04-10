# Product Operations - Sequence Diagram

This sequence diagram describes the typical flow for Product operations (Create, Read, Update, Delete) in the `directory-backend` microservice. The API follows the `*Api.java` + `*Controller.java` pattern and goes controller -> service -> repository, with mapper conversions and external client calls when needed.

```mermaid
sequenceDiagram
    autonumber
    participant Client
    participant ProductController as Controller
    participant ProductService as Service
    participant ProductMapper as Mapper
    participant ProductRepository as Repository
    participant ExternalClient as External (Backbone/Mercury)

    Note over Client,Controller: Create Product
    Client->>Controller: POST /api/v1/products {productTO}
    Controller->>Mapper: toEntity(productTO)
    Mapper-->>Service: productEntity
    Service->>Repository: save(entity)
    Repository-->>Service: savedEntity
    Service->>ExternalClient: notifyCreated(savedEntity) optional
    ExternalClient-->>Service: ack
    Service->>Mapper: toTO(savedEntity)
    Mapper-->>Controller: productTO
    Controller-->>Client: 201 Created + Location header

    Note over Client,Controller: Read Product
    Client->>Controller: GET /api/v1/products/{id}
    Controller->>Service: findById(id)
    Service->>Repository: findById(id)
    Repository-->>Service: entity
    Service->>Mapper: toTO(entity)
    Mapper-->>Controller: productTO
    Controller-->>Client: 200 OK

    Note over Client,Controller: Update Product (optimistic lastUpdate)
    Client->>Controller: PUT /api/v1/products/{id} {productTO, lastUpdate}
    Controller->>Service: update(id, productTO, lastUpdate)
    Service->>Repository: findById(id)
    Repository-->>Service: currentEntity
    Service->>Service: validate lastUpdate matches currentEntity.lastUpdate
    alt conflict
        Service-->>Controller: 409 Conflict
        Controller-->>Client: 409 Conflict
    else ok
        Service->>Mapper: merge updated fields
        Service->>Repository: save(updatedEntity)
        Repository-->>Service: savedEntity
        Service->>Mapper: toTO(savedEntity)
        Service-->>Controller: 202 Accepted + body
        Controller-->>Client: 202 Accepted
    end

    Note over Client,Controller: Delete Product
    Client->>Controller: DELETE /api/v1/products/{id}
    Controller->>Service: delete(id)
    Service->>Repository: findById(id)
    Repository-->>Service: entity
    Service->>Repository: delete(entity)
    Repository-->>Service: ack
    Service-->>Controller: 204 No Content
    Controller-->>Client: 204 No Content
```

Notes

- The controller returns ResponseEntity with proper headers (e.g., `DirectoryAppConstants.MESSAGE_HEADER`) per project conventions.
- Update operations use optimistic-lock-style `lastUpdate` checks returning `202 Accepted` on success and `409 Conflict` on mismatch.
- Mappers are MapStruct-based and live in `src/main/java/com/prx/directory/mapper`.

