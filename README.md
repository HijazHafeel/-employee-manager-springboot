# Employee Manager

A Spring Boot REST API for managing employee records. Employee data is stored in MySQL using Spring Data JPA.

## Requirements

- JDK 21
- MySQL 8 or a compatible MySQL server

The project includes the Maven Wrapper, so a separate Maven installation is not required.

## Database configuration

Create the database before starting the application:

```sql
CREATE DATABASE employee_db;
```

Configure the connection in `src/main/resources/application.properties`. The defaults expect MySQL on `localhost:3306`, a MySQL user named `root`, and a blank password. Update these values to match your local MySQL account:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/employee_db
spring.datasource.username=root
spring.datasource.password=
```

Make sure the username and password have no unintended spaces. Keep real credentials private and do not commit them to source control. Hibernate creates or updates the `employees` table automatically (`spring.jpa.hibernate.ddl-auto=update`).

## Run

From the project root in PowerShell:

```powershell
.\mvnw.cmd spring-boot:run
```

The API is available at `http://localhost:8080/employees`.

## API

All endpoints use the `/employees` path and JSON request/response bodies.

| Method | Path | Description |
| --- | --- | --- |
| `GET` | `/employees` | List all employees |
| `GET` | `/employees/{id}` | Get an employee by ID |
| `POST` | `/employees` | Create an employee |
| `PUT` | `/employees/{id}` | Update an existing employee |
| `DELETE` | `/employees/{id}` | Delete an employee |

Example create request:

```json
{
  "fullName": "Jordan Lee",
  "salary": 65000,
  "email": "jordan.lee@example.com",
  "phoneNumber": "1234567890"
}
```

`fullName` and `email` are required, the email must be valid and unique, salary must be positive when provided, and a provided phone number must contain 10 digits. Creating an employee returns `201 Created`; requests for a missing ID return `404 Not Found`; invalid employee data returns `400 Bad Request`.

## Tests

Run the test suite with:

```powershell
.\mvnw.cmd test
```

The application context test uses the configured MySQL connection, so MySQL must be running and the credentials and database must be valid for tests to pass.
