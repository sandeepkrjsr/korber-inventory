# Korber Inventory Service

## Overview
The **Inventory Service** manages product stock levels and provides APIs to retrieve and update inventory. 
It integrates with an in-memory **H2 database** and uses **Liquibase** for schema management and initial data loading.

---

## Technologies
- Java 25, Spring Boot 4.0.1
- Spring Data JPA, H2 Database
- Liquibase for DB versioning
- JUnit 5 & Mockito for testing
- REST APIs

---

## Setup

Clone the repository:
git clone https://github.com/sandeepkrjsr/korber-inventory.git
cd korber-inventory
Build & run:
./mvnw clean install
./mvnw spring-boot:run

Service runs on http://localhost:8081

H2 console: http://localhost:8081/h2-console (JDBC URL: jdbc:h2:mem:inventorydb)

## API Endpoints

Get Inventory
GET /inventory/{productId}
Returns all batches for a product.

Update Inventory
POST /inventory/update
Request body:
{
  "productId": 101,
  "quantity": 5
}

Database & Liquibase
Schema & initial CSV data (inventory.csv) are managed via Liquibase (db/changelog/db.changelog-master-inventory.xml).

H2 in-memory database used for development & testing.

## Testing

Unit tests: InventoryServiceTest using JUnit 5 + Mockito

Integration tests: @SpringBootTest with H2

Run all tests:
./mvnw test

Notes
Designed to work with Order Service in a microservices architecture.

CRUD operations and stock updates can be tested via Postman.
