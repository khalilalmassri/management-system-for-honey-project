# management-system-for-honey-project
this is a management system, to manage honey sales efficiently
Features
Manage honey products
Store product information in MySQL
REST API using Spring Boot
Create and retrieve products
Product inventory management foundation
Connected to MySQL using Spring Data JPA and Hibernate
Technologies Used
Java 21
Spring Boot
Spring Web
Spring Data JPA
MySQL
Hibernate
Maven
Postman
IntelliJ IDEA
Current API Endpoints
Get All Products
GET /products
Create Product
POST /products

Example JSON body:

{
  "name": "Eucalyptus Honey",
  "size": 850,
  "cost": 16,
  "sellingPrice": 30,
  "stock": 10
}
Database Configuration

Create a MySQL database named:

CREATE DATABASE nectardore_db;

Then configure:

src/main/resources/application.properties

Example:

spring.datasource.url=jdbc:mysql://localhost:3306/nectardore_db
spring.datasource.username=root
spring.datasource.password=YOUR_PASSWORD

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
Running the Project
Clone the repository
Open the project in IntelliJ IDEA
Configure MySQL connection
Run the Spring Boot application
Access APIs through Postman or browser

Server runs on:

http://localhost:8080
Project Goal

This project is being built as a complete backend system for honey or similar businesses to manage:

Products
Inventory
Sales
Payments
Business operations

Future plans include:

Angular frontend
Authentication system
Sales tracking
Profit reports
Dashboard and analytics
Customer and order management
