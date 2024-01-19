# GreenStitch Backend Assignment

A backend for a login and signup REST API with security features using JWT and web tokens for authentication by using the
H2 database & spring boot as the backend framework.

## Installation and Setup

### Prerequisites

```
- Java Development Kit (JDK) 8 or later
- Maven
- Postman (for testing the API)
```

### 1. Clone the Repository

```
git clone https://github.com/ShubhamkumarAnand/GreenStich_Backend_Assignment.git
```

### 2. Go the Project

```
cd GreenStich_Backend_Assignment

```

### 3. Run the Application

```
./mvnw spring-boot:run

```

**The application will start running on [http://localhost:8081](http://localhost:8081)**

### **API Endpoints**

### User Signup

- Method: POST
- Path: `http://localhost:8081/api/auth/signup`
- Description: Register a new user.
- Request Body: User data in the JSON format (e.g., name, email, password).

```json5
{
  "fullName": "Shubham Kumar Anand",
  "password": "imSKAnand@123",
  "email": "ska@gmail.com"
}
```

- Response:

```json5
{
    "id": 1,
    "fullName": "Shubham Kumar Anand",
    "password": "$2a$10$KVzpEHKFpX2ephA7RXLgqumnZKFy3bT8wdJMW3tYH2yqUJcpZPGSG",
    "email": "ska@gmail.com",
}
```

### User Login

- Method: GET
- Path: `http://localhost:8081/api/auth/login`
- Description: Authenticate a user and retrieve their details.
- Authentication: Basic Authentication (Username and Password)
    - Username: [ska@gmail.com](mailto:ska@gmail.com)
    - Password: imSKAnand@123
- Response:

```json5
{
    "id": 1,
    "fullName": "Shubham Kumar Anand",
    "password": "$2a$10$KVzpEHKFpX2ephA7RXLgqumnZKFy3bT8wdJMW3tYH2yqUJcpZPGSG",
    "email": "ska@gmail.com",
}
```

### User Logout

- Method: GET
- Path: `http://localhost:8081/api/auth/logout`
- Description: Authenticate a user and retrieve their details.

```json5
{
  "message": "User Logged Out Successfully"
}
```

### Welcome, Endpoint (Requires Authentication)

- Method: GET
- Path: `http://localhost:8081/hello`
- Description: A protected endpoint that requires authentication to access.
- Authentication: Bearer Token
- Request Header:
    - Authorization: Bearer <token>
- Response: A welcome message string.
- Example:
    - Bearer Token:
      eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJTaGltYmh1Iiwic3ViIjoiSldUIFRva2VuIiwidXNlcm5hbWUiOiJza0BnbWFpbC5jb20iLCJyb2xlIjoiUk9MRV9VU0VSIiwiaWF0IjoxNjg1Njc3Mzg3LCJleHAiOjE2ODU3MDczODd9.VwM2IGD1fABjEcnNoMb4uIyBnYe3_BmZGx33dElaD-E
    - Response: Welcome to GreenSwitch

```text
Hello, From GreenSwitch
```

### Tech Stack

- Java
- Spring Boot
- H2 Database
- Spring Security
- JWT Token
- Maven

### Validation Rules

The following validation rules are applied to the user entity:

- Full Name:
    - Minimum length: 3 characters
    - Maximum length: 20 characters
- Password:
    - At least 8 characters
    - Contains at least one digit
    - Contains at least one lowercase letter
    - Contains at least one uppercase letter
    - Contains at least one special character
- Email:
    - Valid email format

### Development

The project can be imported and run using an IDE - Intellij IDEA Ultimate.

### Test API

You can use Postman to test the API endpoints.

## H2 Database Configuration

The project uses the H2 in-memory database by default.

The application is configured to use the H2 database. The configuration can be found in the `application.properties`
file:

```properties
# Server Port Configuration
server.port=8081

# H2 Database Configuration
spring.datasource.url=jdbc:h2:mem:authdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=imskanand
spring.datasource.password=
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console

```

## **Contributor**

- **[Shubham Kumar Anand](https://github.com/ShubhamkumarAnand)**
 