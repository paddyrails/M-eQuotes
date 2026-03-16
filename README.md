## Introduction

M-eQuotes is the **CS Sales Quotes Service** for Apple CS Sales. It exposes an API to create quotes from a list of offers so that downstream systems can capture, persist, and later act on quote information. Clients send one or more offers (with pricing and discount details) and receive back a created quote with its own identity and associated offers. The service is part of the CS Sales ecosystem and is typically used after offers have been qualified by other services.

---

## Business Architecture

- **Purpose**: Capture and persist quotes built from selected offers so that sales processes (approvals, order conversion, reporting) can operate on a consistent quote record.
- **Capabilities**: Clients submit a list of offers (offer code, product code, and pricing-related fields), and the service creates a quote that groups these offers together and returns an identifier and the offers included. This enables later retrieval and downstream use of quotes by other CS Sales applications.
- **Scope**: The service focuses on quote creation and storage; offer qualification and catalog pricing are assumed to be handled by upstream services. From a business perspective, the service is write-oriented (creating quotes), with read use cases primarily for returning the created quote.
- **Key concepts**: Quotes (a container representing a customer quote over time), offers (line items within a quote with pricing and discounts), and timestamps that track when a quote or offer was created or updated.

---

## Data Architecture

- **Core entities**: Quotes and Offers. A quote has an identifier, created/updated timestamps, and a collection of offers. Each offer has an identifier, offer code, product code, base price, calculated price, discount applied, and a final price, plus audit timestamps.
- **Data store**: Relational store (PostgreSQL). Quotes and offers are stored in related tables, with each quote linking to one or more offers. Monetary values are stored using precise numeric types suitable for financial calculations.
- **Data flow**: Write path: API request submits a list of offers → service validates and maps them into persistent offer records → a new quote is created and linked to these offers → the quote and its offers are saved and the resulting quote (id and offers) is returned. Read path: created quotes can be retrieved for further processing or display, typically keyed by quote identifier.
- **Caching**: The service can cache quote-related data (e.g. recent quotes) in memory (such as Caffeine) to reduce database read load and improve latency for repeated access patterns.

---

## Application Architecture

- **API layer**: REST over HTTP. Core endpoint is a quote creation API that accepts a list of offers in the request body. The contract is defined in an OpenAPI 3 specification (YAML) and used for server/client stub generation and for interactive documentation (for example, via Swagger UI).
- **Service layer**: Orchestrates quote creation by mapping incoming offers into internal representations, generating identifiers, setting timestamps, and delegating persistence to the data access layer. It also shapes the response so callers receive the created quote id and associated offers.
- **Data access layer**: Encapsulates persistence operations for quotes and offers using a repository/DAO pattern, ensuring that transactional behavior and database interactions are handled consistently.
- **Deployment unit**: Built and run as a standalone service (for example, a Spring Boot application). Configuration (database connection, caching, ports, etc.) is externalized via environment variables and configuration files, and API documentation is served from the same runtime.

---

## Technology Architecture

- **Runtime**: Java 17.
- **Framework**: Spring Boot 3.2 for web/API endpoints, data access, caching, and developer tooling.
- **API**: REST with JSON payloads, defined by an OpenAPI 3.0 contract and surfaced via tools such as SpringDoc and Swagger UI for exploration and client generation.
- **Persistence**: JPA/Hibernate with PostgreSQL as the backing database, leveraging connection pooling and PostgreSQL-specific features (such as its dialect) for reliable persistence of quotes and offers.
- **Caching**: Spring Cache abstraction backed by Caffeine, with cache behavior (names, maximum size, time-to-live) configured in application configuration.
- **Build and operations**: Maven-based build producing a runnable service artifact. The service runs as a single process with external dependencies limited mainly to the PostgreSQL database and cache; local development commonly uses a Docker-hosted PostgreSQL instance with credentials aligned to the configured defaults.

