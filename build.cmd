@echo off
echo Building VIT Java Webhook Challenge...

REM Create target directory
if not exist target mkdir target
if not exist target\classes mkdir target\classes

echo Compiling Java sources...

REM Note: This is a simplified build process
REM For a complete Spring Boot application, you would typically use Maven or Gradle

echo.
echo ========================================
echo BUILD INSTRUCTIONS:
echo ========================================
echo.
echo This project requires Maven to build properly.
echo.
echo To install Maven:
echo 1. Download Maven from https://maven.apache.org/download.cgi
echo 2. Extract to a folder (e.g., C:\apache-maven-3.8.8)
echo 3. Add Maven bin directory to your PATH
echo 4. Set JAVA_HOME environment variable
echo.
echo Then run:
echo   mvn clean package
echo.
echo The JAR file will be created in the target directory.
echo ========================================

pause
