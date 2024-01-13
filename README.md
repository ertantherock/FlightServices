# Flight Management System Java Spring Boot Application

## Overview

This is a Java Spring Boot application for the Flight Management System. The application provides RESTful APIs for managing flights, airports, users, and performing flight searches.

## Technologies Used

- Java 17
- Spring Boot 2.7
- Maven
- MySQL(**`database.sql` file provided in project folder**)
- Spring Security (Role-based authentication)
- Swagger (API documentation)
- Postman (API testing)

## UML Diagram of Project

![Project_UML_Diagram.png](..%2Fecommerce_project%2Fspring-boot-ecommerce%2FProject_UML_Diagram.png)

## Features

### Expectations

- [x] **Data Modeling:** Design and model information to be stored in the database.
- [x] **Entities:** Define entities for flights and airports.
- [x] **CRUD Structure:** Implement CRUD operations for flights and airports.
- [x] **Search API:** Create an API endpoint to list flights based on departure, arrival, and dates.
- [x] **REST Service Presentation:** Expose services using REST architecture, implemented in Java (Spring/Spring Boot).
- [x] **Authentication Structure:** Implement an authentication system for user identity verification and authorization.
- [x] **Scheduled Background Jobs:** Create a scheduled job to fetch flight information from a mock third-party API and store it in the database.
- [x] **Git Version Control:** Use Git for version control and host the project on GitHub.
- [x] **Swagger Documentation:** Document the API using Swagger.

### Flight Services

- **Flight Save:** Save a new flight.
- **Delete Flight:** Delete a specific flight by ID.
- **Flight Update:** Update an existing flight.
- **List All Flights:** Retrieve a list of all flights.
- **Find Flight By Id:** Retrieve information about a specific flight by ID. 

### Airport Services

- **Airport Save:** Save a new airport.
- **Delete Airport:** Delete a specific airport by ID.
- **Update Airport:** Update information about an existing airport.
- **List All Airports:** Retrieve a list of all airports.

### Flight Search By Departure City, Arrival City, Departure Date, Return Date

### Mock Data API 

### User Services

- **User Register - Admin:** Register a new admin user. Send `uid` as 1 for `ROLE_Admin`
- **User Login - Admin:** Log in as an admin user. Example user: email: `admin@admin.com`, password: `admin`
- **User Login - Normal:** Log in as a normal user. Example user: email: `normal@normal.com`, password: `normal`
- **User Register - Normal:** Register a new normal user. Send `uid` as 2 for `ROLE_User`

**Note: I have also added an SQL file. You can either import this file or create an admin or normal user via API.**

### API Documentation

Explore the API endpoints using the **Swagger** documentation at [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html).
Tests **Postman**  and documentation at [Postman](https://documenter.getpostman.com/view/24069775/2s9YsNdqC3).

### Security

- Role-based authentication is implemented using Spring Security.
- Admin users have additional privileges for managing flights and airports.



## Configuration

1. **Configure the application.properties file with MySQL database details. For this project you can use SQL file if you want**

2. **Run the application:**

    ```bash
    cd amadeus-java-spring-boot
    mvn spring-boot:run
    ```

3. **Access the application at [http://localhost:8080](http://localhost:8080).**

## Testing

Use Postman or any other API testing tool to test the provided APIs.


