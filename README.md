# VIT Java Webhook Challenge

This Spring Boot application implements the VIT Java webhook challenge requirements.

## How it works

1. **On startup**: Sends a POST request to generate a webhook with your registration details
2. **SQL Problem**: Solves Question 1 (for odd registration numbers) 
3. **Solution Submission**: Submits the SQL solution to the webhook URL with JWT authentication

## Important: Update Your Details

Before running, update the following in `ChallengeOrchestrator.java`:
- `NAME`: Your actual name
- `REG_NO`: Your actual odd registration number  
- `EMAIL`: Your actual email

## Important: Update SQL Solution

Update the SQL query in `SqlSolverService.java` with the actual solution from Question 1 PDF.

## Build and Run

```bash
# Build the project
mvn clean package

# Run the application
java -jar target/webhook-challenge-0.0.1-SNAPSHOT.jar
```

## Project Structure

- `WebhookService`: Handles API calls for webhook generation and solution submission
- `SqlSolverService`: Contains the SQL solution logic
- `ChallengeOrchestrator`: Orchestrates the entire workflow on startup
- DTOs: `WebhookRequest`, `WebhookResponse`, `SolutionRequest`

## Requirements Met

✅ Uses WebClient for HTTP requests  
✅ No controller endpoints - triggers on startup via CommandLineRunner  
✅ Uses JWT in Authorization header for solution submission  
✅ Generates JAR file for submission  

## Submission

- Update your personal details and SQL solution
- Build the JAR file
- Upload to GitHub and submit the repository link and JAR download URL
