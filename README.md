# Traini8

Traini8 is a backend application built with Spring Boot and Spring Data JPA for managing and storing data in a MySQL database.

## Getting Started

These instructions will help you set up and run the Traini8 project on your local machine for development and testing purposes.

**Prerequisites**
Before setting up the project, ensure you have the following installed:

- JDK (Java Development Kit) 8 or later.
- MySQL (relational database management system).

## Installation

1.  Unzip the file

    - Backend_Traini8_HarshJain

2.  Open the project in your favorite IDE

    - IntellJ, Eclipse, VsCode

## Database Setup

1. Create a new database in MySQL:

   - CREATE DATABASE DATABASE_NAME

2. Configure MySQL credentials in application.properties:
   - spring.datasource.url=jdbc:mysql://localhost:3306/DATABASE_NAME
   - spring.datasource.username=your-username
   - spring.datasource.password=your-password
   - spring.jpa.hibernate.ddl-auto=update
   - spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL5Dialect
   - spring.jpa.show-sql=true
   - spring.jpa.properties.hibernate.format_sql=true

## Run the Application

      - mvn clean install

   <br>
      
      - mvn spring-boot:run

Once started, the application will be running at http://localhost:8080/

## Usage

You can interact with the API by sending HTTP requests using tools like Postman or curl. For example:

- curl http://localhost:8080/api/v1/{endpoint}

## Endpoints

1. Save Data (POST)

   Endpoint: http://localhost:8080/api/v1/center

   Method: Post

   - Request Body
   ```
   {
      "centerName": "Harsh Training Center",
      "centerCode": "123456789100",
      "studentCapacity": "50",
      "courseOffered": [
         "Core Java",
         "Advance Java",
      ],
      "contactEmail": "harsh@gmail.com",
      "contactPhone": "0123456789",
      "address": {
         "detailAddress": "Bun Garden",
         "state": "Maharashtra",
         "city": "Pune",
         "pinCode": "411001"
      }
   }
   ```

   - Response Body
   ```
   {
      "id": 2,
      "centerName": "Harsh",
      "centerCode": "123456789100",
      "studentCapacity": "50",
      "courseOffered": [
         "Core Java",
         "Advance Java"
      ],
      "contactEmail": "harsh@gmail.com",
      "contactPhone": "0123456789",
      "createdOn": "07-10-2024 01:23:49", // Current date-time
      "address": {
         "detailAddress": "Bun Garden",
         "state": "Maharashtra",
         "city": "Pune",
         "pinCode": "411001"
      }
   }
   ```

2. Fetch All Data (Get)

   Endpoint: http://localhost:8080/api/v1/centers

   Method: Get

   - Response Body
   ```
   [
      {
         "id": 2,
         "centerName": "JJ",
         "centerCode": "123456789100",
         "studentCapacity": "50",
         "courseOffered": [
            "Core Java",
            "Advance Java"
         ],
         "contactEmail": "harsh@gmail.com",
         "contactPhone": "9112140720",
         "createdOn": "07-10-2024 01:23:49",
         "address": {
            "detailAddress": "Balaji Nagar",
            "state": "Maha",
            "city": "Pune",
            "pinCode": "411043"
         }
      }
   ]
   ```

## Notes

- Ensure you replace your-username and your-password in application.properties with your actual MySQL credentials.
- The schema will be automatically updated in the database when the application starts (spring.jpa.hibernate.ddl-auto=update).

### Author - Dev. Harsh Jain
