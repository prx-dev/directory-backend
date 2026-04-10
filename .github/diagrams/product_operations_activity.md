# Product Operations - Activity Diagram

This activity diagram outlines the higher-level flow for Product lifecycle operations, including validation, mapping, persistence, and notifications.

```mermaid
flowchart TD
    A[Start: Client request arrives] --> B{Request Type}
    B -->|Create| C[Validate payload]
    B -->|Read| D[Parse ID & permissions]
    B -->|Update| E[Validate payload & lastUpdate]
    B -->|Delete| F[Parse ID & permissions]

    C --> G[Map TO -> Entity]
    G --> H[Repository: save - entity]
    H --> I[Optional: notify external systems]
    I --> J[Map Entity -> TO]
    J --> K[Return 201 Created]

    D --> L[Repository: findById]
    L --> M{Found?}
    M -->|Yes| N[Map Entity -> TO]
    M -->|No| O[Return 404 Not Found]
    N --> P[Return 200 OK]

    E --> Q[Repository: findById]
    Q --> R{lastUpdate matches?}
    R -->|No| S[Return 409 Conflict]
    R -->|Yes| T[Map changes & save]
    T --> U[Optional: async notify]
    U --> V[Map -> TO]
    V --> W[Return 202 Accepted]

    F --> X[Repository: findById]
    X --> Y{Found?}
    Y -->|No| O
    Y -->|Yes| Z[Repository: delete]
    Z --> AA[Return 204 No Content]

    style A fill:#f9f,stroke:#333,stroke-width:1px
    style O fill:#faa,stroke:#333,stroke-width:1px
```

Notes and conventions

- Validation includes schema validation, business rules, and permission checks.
- All responses include project-specific headers when required (e.g., `DirectoryAppConstants.MESSAGE_HEADER`).
- External notifications (Backbone/Mercury) are optional and used for sync/async integration per service needs.

