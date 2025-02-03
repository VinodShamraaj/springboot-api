# Spring Boot Application

This is a simple Spring Boot application built with Maven, designed to interact with a Microsoft SQL Server (MSSQL) database.

## Requirements

1. **Java 8+** installed on your machine.
2. **Maven** for building and running the project.
3. A **MSSQL Database** instance running and accessible.

## Setup

1. Clone this repository:

   ```bash
   git clone https://github.com/your-username/your-repo.git
   cd your-repo
   ```

2. Install the required dependencies:

   ```bash
   mvn clean install
   ```

3. **Setup MSSQL Database:**

   - Create a new MSSQL database or use an existing one.
   - Ensure the database has the necessary tables/schema if not already set up.

4. **Update `application.properties`:**

   - In the `src/main/resources/application.properties` file, update the following properties with your database details:

   ```
   spring.datasource.url=jdbc:sqlserver://<your-db-host>:<port>;databaseName=<your-db-name>
   spring.datasource.username=<your-db-username>
   spring.datasource.password=<your-db-password>
   spring.datasource.driver-class-name=com.microsoft.sqlserver.jdbc.SQLServerDriver
   ```

   Replace the placeholders with your actual MSSQL server connection details.

## Running the App

To run the application locally:

```bash
mvn spring-boot:run
```

This will start the Spring Boot app on [http://localhost:8080](http://localhost:8080).

## Notes

- Ensure your MSSQL database is running and accessible from the application.
- If you're using a local database, ensure the database driver is correctly installed and available.
