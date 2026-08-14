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
