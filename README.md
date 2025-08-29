# VIT Java Webhook Challenge

**Student**: Thrisheiyan U K  
**Registration**: 22bit0559  
**Email**: thrisheiyan1@gmail.com

Spring Boot application that implements the VIT Java webhook challenge requirements for odd registration numbers (Question 1).

## Features

- ✅ Generates webhook on startup with student details
- ✅ Implements SQL solution for Question 1
- ✅ Submits solution using JWT authentication
- ✅ Uses WebClient for HTTP requests
- ✅ No controller endpoints (CommandLineRunner)

## Build and Run

```bash
# Build the project
mvn clean package

# Run the application
java -jar target/webhook-challenge-0.0.1-SNAPSHOT.jar
```

## Project Structure

- `ChallengeOrchestrator` - Main workflow orchestration
- `WebhookService` - HTTP request handling
- `SqlSolverService` - SQL solution implementation
- DTOs for API communication

## SQL Solution

Implements solution for **Question 1** (odd registration numbers): Find highest salary not credited on 1st day of month, with employee details (name, age, department).
