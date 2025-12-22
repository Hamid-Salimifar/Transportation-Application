🎟️ Ticket Booking REST API  
Spring Boot • RESTful API • PostgreSQL • JPA • Swagger

## 📌 Overview
This project is a RESTful ticket booking system developed using Spring Boot.  
It provides a clean and well-structured backend API that allows users to search for tickets, view ticket details, and complete ticket purchases.

The system follows a layered architecture and uses DTOs to separate internal domain models from API responses. It includes input validation, centralized exception handling, and interactive API documentation using Swagger/OpenAPI.

This project is suitable as a backend service for web or mobile applications and demonstrates best practices in REST API design.

---

## ✨ Key Features

### 🎫 Ticket Management
- Search tickets by type (e.g. bus, train, airplane)
- Search tickets by date and destination
- Filter tickets by price range and capacity
- Retrieve detailed information for a specific ticket

### 🛒 Ticket Purchase
- Select a ticket for purchase
- Submit a purchase request
- View purchase results
- Retrieve a list of tickets purchased by a user

### 👤 User Interaction
- Associate purchases with users
- View all tickets purchased by a specific user

---

## 🧱 Architecture & Design

The application follows a **layered architecture**:

- **Controller Layer**  
  Exposes RESTful APIs and handles HTTP requests and responses using `ResponseEntity`.

- **Service Layer**  
  Contains business logic for searching tickets, validating purchases, and processing transactions.

- **Repository Layer**  
  Uses Spring Data JPA to interact with the database and perform custom queries.

- **Entity Layer**  
  Represents the core domain models such as tickets, users, and purchases.

- **DTO Layer**  
  Ensures clean API contracts by converting entities to request/response objects.

---

## 🔄 Data Transfer Objects (DTOs)
DTOs are used to ensure separation between persistence models and API responses.

Implemented DTOs include:
- Search request
- Ticket response
- Purchase request
- Purchase result
- User tickets list

---

## ⚠️ Validation & Error Handling
- Input validation applied to all request payloads
- Meaningful validation error messages returned to the client
- Centralized exception handling using a global exception handler
- Proper HTTP status codes for all API responses

---

## 📖 API Documentation
The API is fully documented using **Swagger / OpenAPI**.

Features:
- Interactive API testing interface
- Clear request and response models
- Defined error responses and status codes

Once the application is running, access Swagger UI at:
