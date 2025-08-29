# Setup Instructions

## 1. Update Your Personal Details

Edit `src/main/java/com/example/webhookchallenge/service/ChallengeOrchestrator.java`:

```java
private static final String NAME = "Your Full Name";
private static final String REG_NO = "YOUR_ODD_REG_NUMBER"; 
private static final String EMAIL = "your.email@example.com";
```

## 2. Update SQL Solution

Since you have an odd registration number, you need Question 1.

1. Get the actual Question 1 from: "E:\Study Material\SQL Question 1 JAVA .pdf"
2. Solve the SQL problem 
3. Update `src/main/java/com/example/webhookchallenge/service/SqlSolverService.java`
4. Replace the placeholder SQL query in the `solveQuestion1()` method with your actual solution

## 3. Build Requirements

You need Maven installed to build this project:

1. Download Maven from https://maven.apache.org/download.cgi
2. Extract to a folder (e.g., C:\apache-maven-3.8.8)
3. Add Maven's bin directory to your PATH environment variable
4. Set JAVA_HOME environment variable to your JDK installation

## 4. Build and Run

```bash
# Build the project
mvn clean package

# Run the application
java -jar target/webhook-challenge-0.0.1-SNAPSHOT.jar
```

## 5. Expected Flow

1. Application starts
2. Sends POST to generate webhook with your details
3. Receives webhook URL and access token
4. Solves SQL Question 1 
5. Submits solution to webhook URL with JWT token
6. Prints success message

## 6. Submission

1. Push code to GitHub
2. Include JAR file in releases
3. Submit GitHub repo link and JAR download URL at: https://forms.office.com/r/5Kzb1h7fre
