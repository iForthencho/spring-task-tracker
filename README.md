# spring-task-tracker

Task tracking application to showcase a simple RESTful API using Java and Spring Boot.

### Features

- CRUD operation for tasks
- Basic user/endpoint authentication using Spring security
- Endpoint error handling

### Prerequisites

- Java 17 or later
- Maven 3.5+
- MySQL 5.7+

### Setting Up

1. Clone the repository:
    ```
    https://github.com/iForthencho/spring-task-tracker.git
    ```
2. Setting up the MySQL database
   1. Create a new MySQL local instance and run the provided MySQL scripts found in the "MySQL-scripts" folder.
   2. Update 'src/main/resources/application.properties' with your MySQL credentials.
   ```
    spring.datasource.username=
    spring.datasource.password=
   ```
3. Build the application:
    ```
    mvnw package
    ```
4. Run the application:
    ```
    cd target/
    java -jar demo-0.0.1-SNAPSHOT.jar
    ```
   The server will start on port '8080'.

### API Endpoints
| HTTP Method | Endpoint | Description |
| --- | --- | --- |
| GET | /api/tasks | List all tasks |
| GET | /api/tasks/{id} | Retrieve a task by ID |
| POST | /api/tasks | Create a new task |
| PUT | /api/tasks/{id} | Update a task by ID |
| DELETE | /api/tasks/{id} | Delete a task by ID |

