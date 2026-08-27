# BridgeLabz Refresher Training Progress Log

- This repository tracks my daily learning journey during the `Refresher Training Program`

## Day 1 – DBMS Fundamentals & RDBMS Basics

**Date:** 31-July-2026

### Content Covered

- Learned DBMS Fundamentals and RDBMS Basics
- Studied Relational vs Non-Relational Databases
- Introduction to MySQL and RDBMS concepts
- Learned DDL and DML commands
- Keys & Constraints
- Set up MySQL development environment

### Practical work

- Installed and configured MySQL
- Practiced basic SQL commands
- Perform CRUD Operations using DDL and DML
- Created HealthClinicDB database

### Code Link : [Day-1](https://github.com/Suraj-Kumar14/BridgeLabz-Training/tree/Refresher-Training/Day-1)

---

## Day 2: ER Diagrams, Junction Tables, and Database Normalization

**Date:** 03-August-2026

- **Focus Area:** Entity-Relationship (ER) Diagrams, Many-to-Many Relationships, Data Anomalies, and Normalization up to Third Normal Form (3NF).

### Core Concepts Covered

- Learned ER Diagram (ERD) design principles
- Studied entities, attributes, relationships, and cardinality
- Understood one-to-one, one-to-many, and many-to-many relationships
- Learned database indexing concepts and their impact on query performance
- Studied Normalization techniques:
  - First Normal Form (1NF)
  - Second Normal Form (2NF)
  - Third Normal Form (3NF)
  - Boyce-Codd Normal Form (BCNF)

- Finalized the ER Diagram for the Health Clinic Application
- Normalized the Patient, Doctor, Department, and Appointment schema to reduce redundancy and improve data integrity

### Practical Work

- Designed the ER Diagram for the Health Clinic Application
- Defined Primary Keys and Foreign Keys to establish table relationships
- Implemented proper entity relationships with correct cardinality
- Created and verified the database schema using ER modeling tools
- Applied normalization up to 3NF to eliminate redundancy and update anomalies
- Practice Constraints and Aggregate method in Health clinic practice work

### Code Link : [Day-2](https://github.com/Suraj-Kumar14/BridgeLabz-Training/tree/Refresher-Training/Day-2)

---

## Day 3 – Joins, Stored Procedures & Triggers

**Date:** 04-August-2026

### Content Covered

- Learned SQL Joins (INNER JOIN, LEFT JOIN, RIGHT JOIN, and FULL OUTER JOIN simulation in MySQL)
- Practiced retrieving related data using joins across multiple tables
- Studied Stored Procedures and their creation, execution, and benefits
- Learned Triggers and their use cases for automating database operations
- Implemented joins for the Health Clinic App schema

### Practical Tasks Completed

- Wrote INNER JOIN queries to retrieve patient, doctor, and appointment details
- Implemented LEFT JOIN and RIGHT JOIN to handle unmatched records
- Simulated FULL OUTER JOIN using `LEFT JOIN`, `RIGHT JOIN`, and `UNION`
- Created basic Stored Procedures for reusable database operations
- Created basic Triggers to automate actions on table events
- Applied joins to the Health Clinic App database

### Learning Outcome

- Gained hands-on experience with SQL joins for combining data from multiple tables
- Improved practical SQL skills by implementing real-world database scenarios

### Code Link : [Day-3](https://github.com/Suraj-Kumar14/BridgeLabz-Training/tree/Refresher-Training/Day-3)

---

## Day 4 – JDBC & Health Clinic App Completion

**Date:** 05-August-2026

### Topics Covered

- JDBC Introduction
- Connecting Java Application to MySQL
- CRUD Operations using JDBC
- PreparedStatement & CallableStatement
- ResultSet & ResultSetMetaData
- Batch Processing
- Transactions (Commit & Rollback)

### Health Clinic App

Completed a console-based **Health Clinic Management System** using **Java, JDBC, and MySQL** with the following modules:

- Patient Management
- Doctor Management
- Department Management
- Appointment Management
- Visit Management
- Billing Management

### JDBC Features Implemented

- Database Connection
- CRUD Operations
- Stored Procedures
- Transactions

### Technologies Used

- Java
- JDBC
- MySQL
- Eclipse IDE

## Learning Outcome

- Connected Java with MySQL using JDBC.
- Performed CRUD operations on database tables.
- Executed stored procedures using `CallableStatement`.
- Implemented batch processing and transactions.
- Built a complete console-based Health Clinic Management System.

### Code Link : [Day-4](https://github.com/Suraj-Kumar14/BridgeLabz-Training/tree/Refresher-Training/Day-4)

---

## Day 5 – Tomcat, Servlets & Spring Introduction

**Date:** 06-August-2026

### Topics Covered

- Introduction to Backend Development
- Apache Tomcat
- Tomcat as a Web/Application Server
- Servlet Architecture
- Servlet Lifecycle
- Introduction to Spring Framework
- Spring Core
- Inversion of Control (IoC)
- Dependency Injection (DI) Basics
- Spring IoC Container
- Beans in Spring

### Hands-on

- Created a simple Spring Core project.
- Explored the Spring IoC Container.
- Implemented a simple Bean using Dependency Injection.

### Technologies Used

- Java
- Apache Tomcat
- Servlet API
- Spring Framework
- Maven
- Eclipse IDE

### Learning Outcome

- Understood the role of Tomcat as a web/application server.
- Learned the Servlet lifecycle and request handling.
- Understood Spring Framework fundamentals.
- Explored IoC and Dependency Injection concepts.
- Created and managed Spring Beans using the IoC container.

### Code Link : [Day-5](https://github.com/Suraj-Kumar14/BridgeLabz-Training/tree/Refresher-Training/Day-5)

---

## Day 6 - Backend Basics: Spring MVC

**Date:** 07-August-2026

### 📌 Topics Covered

- Spring MVC Architecture
- DispatcherServlet
- Controllers
- Views (JSP)
- Request Mapping and Handling
- MVC Request Flow

### 💻 Hands-on Project

#### Login & Registration System

A simple Spring MVC web application that demonstrates:

- User Registration
- User Login
- Form Handling
- Request Mapping using Controllers
- Passing Data from Controller to View
- JDBC Integration with MySQL

#### 🛠 Technologies Used

- Java 17
- Spring MVC
- Apache Tomcat
- Maven
- MySQL
- Spring JDBC
- JSP
- HTML & CSS

#### 🎯 Learning Outcome

- Understood Spring MVC architecture.
- Learned request mapping and controller handling.
- Built a Login & Registration application using Spring MVC and MySQL.

### Code Link : [Day-6](https://github.com/Suraj-Kumar14/BridgeLabz-Training/tree/Refresher-Training/Day-6)

---

## Day 7 - Spring REST API & Request Handling

**Date:** 10-August-2026

### Topics

- Spring REST API
- RESTful Endpoints
- Request Handling
- H2 In-Memory Database
- Entity, DTO and Mapper
- Repository and Service
- CRUD Operations
- Distributed Architecture
- Postman Testing

### Contacts App

Developed a Contacts REST API using Spring Boot.

Contact fields:

- ID
- Name
- Phone
- Email
- Address

### REST Endpoints

| Operation | Method | URL            |
| --------- | ------ | -------------- |
| Create    | POST   | /contacts      |
| Get All   | GET    | /contacts      |
| Get By ID | GET    | /contacts/{id} |
| Update    | PUT    | /contacts/{id} |
| Delete    | DELETE | /contacts/{id} |

### H2 Database

Used H2 in-memory database for storing and testing contact data.

### Postman

All CRUD APIs were tested using Postman.

### Technologies

- Java 17
- Spring Boot
- Spring Web
- Spring Data JPA
- H2
- Maven
- Postman

### Distributed Architecture

Distributed architecture divides an application into independent services.

### Code Link : [Day-7](https://github.com/Suraj-Kumar14/BridgeLabz-Training/tree/Refresher-Training/Day-7)

---

## Day 8 - API Testing Tools & SDLC

**Date:** 11-August-2026

### Topics Covered

- REST Assured
- JSON Server
- REST API Testing
- API Mocking
- Software Development Life Cycle (SDLC)
- Backend Developer Role in SDLC
- Contacts App API Testing

### Contacts App

The Contacts App backend was continued and REST APIs were tested using REST Assured.

The application supports:

- Create Contact
- Get All Contacts
- Get Contact By ID
- Update Contact
- Delete Contact
- Validation
- Global Exception Handling

## REST Endpoints

| Operation         | Method | Endpoint       |
| ----------------- | ------ | -------------- |
| Create Contact    | POST   | /contacts      |
| Get All Contacts  | GET    | /contacts      |
| Get Contact By ID | GET    | /contacts/{id} |
| Update Contact    | PUT    | /contacts/{id} |
| Delete Contact    | DELETE | /contacts/{id} |

## REST Assured

REST Assured is a Java library used for testing REST APIs.

Basic testing flow:

    given()
       |
       v
    when()
       |
       v
    then()

REST Assured was used to test the Contacts App API endpoints and verify the API responses and status codes.

### JSON Server

JSON Server is used to create mock REST APIs using JSON data.

It is useful for testing APIs when the actual backend service is not available.

### SDLC

SDLC stands for Software Development Life Cycle.

The main phases are:

    Requirement
        |
        v
      Design
        |
        v
    Development
        |
        v
      Testing
        |
        v
    Deployment
        |
        v
    Maintenance

## Backend Developer Role

A backend developer mainly works on:

- REST API development
- Business logic
- Database integration
- Validation
- Exception handling
- API testing
- Deployment support

### API Testing

The Contacts App endpoints were tested using REST Assured.

Testing included:

- POST API
- GET API
- PUT API
- DELETE API
- Status code verification
- Request and response validation
- Validation error testing
- Exception handling testing

## Technologies Used

- Java 17
- Spring Boot
- Spring Web
- Spring Data JPA
- H2 Database
- Maven
- REST Assured
- JSON Server

## Conclusion

The Contacts App was tested using REST Assured and API mocking was explored using JSON Server. SDLC phases and the role of a backend developer were also studied.

### Code Link : [Day-8](https://github.com/Suraj-Kumar14/BridgeLabz-Training/tree/Refresher-Training/Day-8)

---

## Day 9 - Spring Boot Fundamentals

**Date:** 12-August-2026

### Topics Covered

- Spring Boot Fundamentals
- Auto-Configuration
- Spring Boot Starters
- Embedded Server
- Spring Controller
- REST API
- Continue Contacts App Backend
- Search Functionality
- Favorite Contact Functionality
- Duplicate Contact Prevention
- Postman API Testing

### Spring Boot Fundamentals

Spring Boot is used to create Spring applications quickly with minimum configuration.

### Auto-Configuration

Spring Boot automatically configures required components based on the dependencies available in the project.

### Spring Boot Starters

Spring Boot Starters provide the required dependencies for specific functionality.

Examples:

- `spring-boot-starter-web`
- `spring-boot-starter-data-jpa`
- `spring-boot-starter-validation`
- `spring-boot-starter-test`

### Embedded Server

Spring Boot provides an embedded Tomcat server.

Because of this, the application can run directly without manually installing and configuring a separate server.

### Spring Controller

The Controller handles HTTP requests and sends responses.

### Conclusion

Day 9 focused on Spring Boot fundamentals including auto-configuration, starter dependencies, embedded server, Spring Controllers, and REST APIs.

The Contacts App was enhanced with search functionality, favorite contacts, duplicate email and phone prevention, validation, global exception handling, and automated testing using JUnit, Mockito, REST Assured, and repository testing with H2.

### Code Link : [Day-9](https://github.com/Suraj-Kumar14/BridgeLabz-Training/tree/Refresher-Training/Day-9)

---

## Day 10 - Dependency Injection & H2 Database

**Date:** 13-August-2026

Today I worked on the **Employee Payroll App backend** using **Spring Boot, Spring JDBC, and H2 Database**.

The main focus was understanding **Dependency Injection**, integrating **H2 Database**, connecting the database using **JdbcTemplate**, and building a structured Employee Payroll REST API.

### Topics Covered

- Understood Dependency Injection (DI) in Spring Boot.
- Used **constructor injection** to inject dependencies.
- Connected different application layers using DI:
  - Controller → Service
  - Service → DAO
  - DAO → JdbcTemplate
- Used Spring annotations:
  - `@RestController`
  - `@Service`
  - `@Repository`
- Understood how Spring creates and manages beans.

### 1. H2 Database Integration

- Integrated H2 in-memory database with Spring Boot.
- Configured H2 database connection.
- Used `JdbcTemplate` to communicate with the database.
- Created database tables using `schema.sql`.
- Inserted initial data using `data.sql`.
- Created relationships between:
  - `departments`
  - `employees`

### 2. Employee Payroll Database Structure

Created two main tables.

#### Department

department_id
department_name

#### Employee

id
name
email
department_id
salary
joining_date

### Code Link : [Day-10](https://github.com/Suraj-Kumar14/BridgeLabz-Training/tree/Refresher-Training/Day-10)

---

## Day 11 - Spring Services, Spring JPA & Spring JDBC

**Date:** 14-August-2026

### Topics Covered

- Spring REST API - Service Layer Design
- Spring Service Layer and Dependency Injection
- Spring JDBC
- JdbcTemplate
- Spring JPA
- Spring Data JPA Repositories
- JPA Entity Mapping
- Repository Pattern
- CRUD Operations
- Employee-Department Entity Relationship
- Migration from Spring JDBC to Spring JPA
- Pagination
- Sorting
- Custom JPA Queries
- Postman API Testing

### Spring REST API - Service Layer Design

The Service layer contains the business logic of the application.

It acts as a bridge between the Controller and Repository layers.

The basic flow is:

```text
Client
   ↓
Controller
   ↓
Service
   ↓
Repository
   ↓
Database

```

### Code Link : [Day-11](https://github.com/Suraj-Kumar14/BridgeLabz-Training/tree/Refresher-Training/Day-11)

---

## Day 12 — Spring Scopes, Logging, Maven & Postman

**Date:** 17-August-2026

### 📚 Topics Covered

- **Maven**
  - Build & dependency management
  - `pom.xml` and Maven lifecycle
  - Common Maven commands

- **Postman**
  - API testing workflow
  - Created Postman collections
  - Tested GET, POST, PUT & DELETE APIs
  - Tested success and error scenarios

- **Spring Bean Scopes**
  - Singleton
  - Prototype
  - Request
  - Session

- **Logging**
  - Logging in Spring Boot applications
  - INFO, DEBUG, WARN & ERROR logs
  - Used logging for debugging and monitoring

- **Employee Payroll Backend**
  - Completed Employee Payroll backend
  - Employee & Department REST APIs
  - DTOs and validation
  - Exception handling
  - Database integration

- **API Testing**
  - Tested all Employee Payroll endpoints
  - Created and executed Postman collections
  - Verified HTTP status codes and API responses

### 🛠️ Technologies

`Java` `Spring Boot` `Spring JDBC` `H2` `Maven` `Postman` `REST API` `Logging`

### Code Link : [Day-12](https://github.com/Suraj-Kumar14/BridgeLabz-Training/tree/Refresher-Training/Day-12)

---

# Day 13 – Advanced Backend Development

**Date:** 18-August-2026

## Spring Security & JWT Authentication

**Project:** Fundoo Notes Application  
**Module:** User Management & Authentication

---

## 📚 Topics Covered

- Spring Boot Recap
- Spring Security Fundamentals
- Authentication & Authorization
- Password Encryption using BCrypt
- JWT (JSON Web Token)
- Token-Based Authentication
- JWT Generation & Validation
- JWT Authentication Filter
- `UserDetailsService`
- `AuthenticationManager`
- Stateless Session Management
- DTO-based API Design
- Bean Validation
- Global Exception Handling
- MySQL with Spring Data JPA
- Postman API Testing

---

## 👤 Fundoo Notes – User Management

Implemented the User Management module with the following operations:

| Operation       | Method | Endpoint                    | Authentication |
| --------------- | ------ | --------------------------- | -------------- |
| Register        | POST   | `/api/auth/register`        | Public         |
| Login           | POST   | `/api/auth/login`           | Public         |
| Forgot Password | POST   | `/api/auth/forgot-password` | Public         |
| Reset Password  | POST   | `/api/auth/reset-password`  | Public         |

---

## 🔐 Spring Security

Implemented Spring Security for:

- User authentication
- Password encryption using BCrypt
- JWT validation
- Securing APIs
- Stateless authentication
- Custom JWT authentication filter

### Password Encryption

Passwords are encrypted before storing them in the database.

```java
@Bean
public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
}
```

### Code Link : [Day-13](https://github.com/Suraj-Kumar14/BridgeLabz-Training/tree/Refresher-Training/Day-13)

---

## Day 14 – Advanced Backend Development

**Date:** 19-August-2026

### Authorization & JPA for Notes Management

**Project:** Fundoo Notes Application  
**Module:** Authentication, Authorization & Notes Management

### 📚 Topics Covered

- Authentication vs Authorization
- Secure Token-Based Verification
- Spring Security Authorization
- JWT-Based Authentication
- Role-Based Access Control
- Spring Data JPA
- JPA Entity Relationships
- Entity Mapping
- `@OneToMany`
- `@ManyToOne`
- `@OneToOne`
- `@ManyToMany`
- JPA Repository
- Derived Query Methods
- User-Note Relationship
- Fundoo Notes Authentication & Authorization Module
- Fundoo Notes Notes Management Module
- Create Notes
- Delete Notes
- DTO-based API Design
- Bean Validation
- Exception Handling
- MySQL Database
- Postman API Testing

### 🔐 Authentication vs Authorization

#### Authentication

Authentication verifies **who the user is**.

Example:

```text
User → Login → Username & Password Verification → JWT Token
```

### Code Link : [Day-14](https://github.com/Suraj-Kumar14/BridgeLabz-Training/tree/Refresher-Training/Day-14)

---

## Day 15 – Advanced Backend Development

**Date:** 20-August-2026

**Project:** Fundoo Notes Application

### 📚 Topics Covered

- Organisation-oriented REST APIs
- State-based filtering
- Pin / Unpin Notes
- Archive / Unarchive Notes
- Trash / Restore Notes
- Search & Filter APIs
- Tags / Labels Management
- JWT-based user-specific operations
- Postman API testing

### 📌 Organisation Modules

#### Pin / Archive / Trash

Implemented note organisation using different states:

- 📌 **Pin** – Mark important notes.
- 📦 **Archive** – Move notes out of the active list.
- 🗑️ **Trash** – Move notes to trash.
- ♻️ **Restore** – Restore trashed notes.

#### 🔍 Search & Filter

Implemented search and filtering using query parameters.

Example:

```http
GET /api/notes/search?keyword=java&pinned=true&archived=false
```

Supported filters:

- Keyword
- Pinned
- Archived
- Trashed
- Tags

#### 🏷️ Tags / Labels

Implemented label management:

- Create Label
- Get Labels
- Update Label
- Delete Label
- Add Label to Note
- Remove Label from Note

### 🔐 Security

All note organisation operations are protected using **JWT authentication** and are restricted to the authenticated user's own notes.

### 🧪 Testing

Tested APIs using **Postman**, including:

- Pin / Unpin
- Archive / Unarchive
- Trash / Restore
- Search & Filter
- Label CRUD
- Note-Label mapping
- Authorization and error scenarios

### 🎯 Key Learning

Learned how to design **state-based REST APIs**, implement flexible search/filter queries, and manage note organisation using **Pin, Archive, Trash and Tags**.

### Code Link : [Day-15](https://github.com/Suraj-Kumar14/BridgeLabz-Training/tree/Refresher-Training/Day-15)

---

## Day 16 – Advanced Backend Development

**Date:** 21-August-2026

### JMS (Asynchronous Messaging) & Redis Caching

**Project:** Fundoo Notes Application
**Module:** Reminder, Notification & Token Caching

### 📚 Topics Covered

- JMS (Java Message Service)
- Asynchronous & non-blocking messaging
- Background processing using JMS
- Message Producer & Consumer
- Queue-based communication
- Reminder & Notification Module using JMS
- Redis Caching
- Token caching using Redis
- Improving authorization performance with Redis

### 🔹 JMS (Java Message Service)

JMS is used for **asynchronous communication** between different parts of an application.

Instead of processing every task immediately, the application can send a message to a queue and continue its main operation. A consumer processes the message in the background.

#### Benefits

- Asynchronous processing
- Non-blocking operations
- Background task execution
- Loose coupling between components
- Better application performance
- Reliable message-based communication

#### Basic Flow

```text
User Request
     ↓
Controller
     ↓
JMS Producer
     ↓
Message Queue
     ↓
JMS Consumer
     ↓
Background Processing
     ↓
Reminder / Notification
```

### 🔹 Fundoo Notes – Reminder & Notification Module

JMS was integrated into the Fundoo Notes application to handle reminder and notification processing asynchronously.

### Flow

```text
Create / Update Reminder
        ↓
JMS Producer
        ↓
Message Queue
        ↓
JMS Consumer
        ↓
Process Reminder
        ↓
Send Notification
```

This prevents notification processing from blocking the main API request.

### 🔹 Redis Caching

Redis is an **in-memory key-value data store** commonly used for caching.

In Fundoo Notes, Redis is used to cache authentication-related data such as JWT tokens.

### Token Caching Flow

```text
User Login
    ↓
JWT Token Generated
    ↓
Token Stored in Redis
    ↓
User Sends Request
    ↓
JWT Authentication Filter
    ↓
Check Token in Redis
    ↓
Valid → Continue Request
Invalid → Reject Request
```

### 🔹 Benefits of Redis Token Caching

- Faster token validation
- Reduces repeated database operations
- Improves authorization performance
- Supports token invalidation
- Helps manage token expiration
- Useful for logout and password-reset scenarios

### 🔹 Technologies Used

- Java
- Spring Boot
- Spring JMS
- JMS Message Queue
- Redis
- Spring Data Redis
- Spring Security
- JWT
- MySQL

### 🎯 Day 16 Outcome

Implemented asynchronous processing using **JMS** for the Fundoo Notes Reminder & Notification module and introduced **Redis caching** for JWT token management, improving application responsiveness and authorization performance.

### Code Link : [Day-16](https://github.com/Suraj-Kumar14/BridgeLabz-Training/tree/Refresher-Training/Day-16)

---

# Day 17 – RabbitMQ & Spring Batch (Excel)

**Date:** 24 August 2026

## 📚 Topics Covered

### 1. RabbitMQ – Message Queuing

- RabbitMQ message queuing fundamentals
- Producer, Consumer, Queue, Exchange and Routing Key
- Asynchronous communication using RabbitMQ
- Decoupling application components using message queues
- Exploring RabbitMQ for smooth background and asynchronous operations

### 2. Spring Batch – Excel Processing

- Understanding batch processing
- Reading data from Excel files
- Processing records in batches
- Writing/exporting data to Excel
- Understanding Spring Batch components:
  - Job
  - Step
  - ItemReader
  - ItemProcessor
  - ItemWriter

### 3. Fundoo Notes App

- Explored **File Attachment Module** _(Optional)_
- RabbitMQ can be used for background/asynchronous operations such as:
  - File processing
  - Notifications
  - Background tasks
- Spring Batch can be used for bulk Excel import/export of notes.

## 🎯 Learning Objective

To understand how **RabbitMQ** handles asynchronous communication and how **Spring Batch** processes large amounts of data efficiently, including Excel import/export operations.

## 🛠️ Technologies

- Java
- Spring Boot
- RabbitMQ
- Spring Batch
- Apache POI
- Excel
- Maven

## 📂 Fundoo Notes App Integration

```text
Fundoo Notes App
       |
       ├── RabbitMQ
       │     └── Background / Async Operations
       │
       ├── Spring Batch
       │     ├── Excel Import
       │     └── Excel Export
       │
       └── File Attachment Module
             └── Optional

```

### 🎯 Day 17 Outcome

- Learned the fundamentals of RabbitMQ message queuing.
- Understood asynchronous/background processing.
- Learned the basics of Spring Batch.
- Implemented/Explored Excel import and export using batch processing.
- Explored how RabbitMQ and Spring Batch can be integrated into the Fundoo Notes App.

### Code Link : [Day-17](https://github.com/Suraj-Kumar14/BridgeLabz-Training/tree/Refresher-Training/Day-17)

---

## Day 18 – REST API Patterns, Global Exception Handling, AOP & Spring Cloud

**Date:** 24-August-2026

**Project:** Fundoo Notes Application  
**Module:** Advanced Backend Development

### 📚 Topics Covered

- REST API Design Patterns
- Spring Scopes
- DTO ↔ Entity Mapping
- Global Exception Handling
- Logging Best Practices
- AOP (Aspect-Oriented Programming)
- Introduction to Spring Cloud
- Backend Error Handling & Hardening

### 🎯 Objectives

- Design clean and consistent REST APIs.
- Separate DTOs from JPA entities.
- Implement centralized exception handling using `@ControllerAdvice`.
- Add meaningful application logging.
- Understand and implement AOP for cross-cutting concerns.
- Revisit Spring Bean scopes.
- Understand the fundamentals of Spring Cloud.
- Improve the overall reliability and maintainability of the Fundoo Notes backend.

### 🛠️ Fundoo Notes Backend Improvements

The application backend is consolidated and hardened by implementing:

- Standard HTTP status codes and REST API responses.
- Request/Response DTO mapping.
- Centralized exception handling.
- Custom application exceptions.
- Validation error handling.
- Structured logging for important application events.
- AOP-based logging and cross-cutting functionality.
- Clean Controller → Service → Repository architecture.
- Better error handling across authentication and notes modules.

### 🧩 Global Exception Handling

Implemented centralized exception handling using:

- `@ControllerAdvice`
- `@ExceptionHandler`
- Custom exceptions
- Validation exception handling
- Consistent error response structure

Example flow:

```text
Controller
    ↓
Service
    ↓
Exception
    ↓
GlobalExceptionHandler
    ↓
Standard Error Response

```

### Code Link : [Day-18](https://github.com/Suraj-Kumar14/BridgeLabz-Training/tree/Refresher-Training/Day-18)

---

## Day-19: Monolith vs Microservices & Spring Boot Microservices

**Date:** 26 August 2026

### 📚 Topics Covered

- Monolithic Architecture vs Microservices Architecture
- Advantages and disadvantages of Monolithic Architecture
- Advantages and disadvantages of Microservices Architecture
- Spring Boot Microservices
- Microservices Project Structure
- Inter-Service Communication
- API Gateway
- Eureka Service Discovery
- Fundoo Notes Microservices Decomposition
- User Management Service
- Authentication Service

### 1. Monolithic Architecture

Monolithic Architecture is an application architecture where all the functionalities of an application are developed and deployed as a **single application**.

#### Fundoo Notes Monolithic Architecture

The original Fundoo Notes application contains multiple functionalities inside one Spring Boot application:

```text
                     Fundoo Notes Application
                              |
          +-------------------+-------------------+
          |                   |                   |
   User Management      Authentication       Notes Management
          |                   |                   |
   Registration              Login          Create Notes
   Email OTP            Forgot Password     Update Notes
   Verify OTP            Reset Password      Delete Notes
   Resend OTP                                  Pin
                                               Archive
                                               Trash
                                               Search
                                               Tags
          |
          v
      MySQL Database
```

#### Fundoo Notes MicroServices Architecture

                              CLIENT
                                |
                                v
                       +----------------+
                       |  API GATEWAY   |
                       +----------------+
                                |
                                v
                       +----------------+
                       | EUREKA SERVER  |
                       | Service        |
                       | Discovery      |
                       +----------------+
                                |
              +-----------------+-----------------+
              |                 |                 |
              v                 v                 v
       +-------------+   +-------------+   +-------------+
       |    AUTH     |   |    USER     |   |    NOTE     |
       |   SERVICE   |   |   SERVICE   |   |   SERVICE   |
       +-------------+   +-------------+   +-------------+
              |                 |                 |
              v                 v                 v
           Auth DB           User DB           Note DB
              |
       +------+------+
       |             |
       v             v
     Redis        RabbitMQ
                     |
                     v
                 Email Service
                     |
                     v
                    SMTP

### Code Link : [Day-19](https://github.com/Suraj-Kumar14/BridgeLabz-Training/tree/Refresher-Training/Day-19)

---

## Day 20 - Service Registry (Eureka) & Microservices Completion

**Date:** 27 August 2026  
**Project:** Fundoo Notes Application  
**Topic:** Microservices Architecture, Service Discovery & Application Decomposition

### 📌 Overview

Day 20 focuses on completing the migration of the **Fundoo Notes Application** from a Monolithic Architecture to a Microservices Architecture.

The application is divided into independent services based on business responsibilities.

The architecture uses:

- **Netflix Eureka** for Service Discovery
- **Spring Cloud Gateway** as the single entry point
- **JWT** for Authentication and Authorization
- **MySQL** for persistent data storage
- **Redis** for caching and temporary data
- **RabbitMQ** for asynchronous messaging
- **JMS / Artemis** for asynchronous background processing
- **SMTP** for email communication

### 🎯 Learning Objectives

- Understand Microservices Architecture
- Understand Service Registry and Service Discovery
- Implement Eureka Server
- Register microservices with Eureka
- Understand API Gateway and request routing
- Separate business responsibilities into services
- Understand inter-service communication
- Implement Authentication and Authorization
- Understand database ownership in microservices
- Implement asynchronous communication
- Understand Redis caching
- Understand RabbitMQ messaging
- Understand JMS / Artemis messaging
- Complete the Fundoo Notes microservices architecture

### 🏗️ Final Project Structure

```text
Day-20/
└── fundoo-microservices/
    │
    ├── fundoo-eureka-server/
    │
    ├── fundoo-api-gateway/
    │
    ├── fundoo-auth-service/
    │
    ├── fundoo-note-service/
    │
    ├── fundoo-notification-service/
    │
    └── README.md

```

### Code Link : [Day-20](https://github.com/Suraj-Kumar14/BridgeLabz-Training/tree/Refresher-Training/Day-20)

---
