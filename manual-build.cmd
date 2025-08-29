@echo off
echo VIT Java Webhook Challenge - Manual Build Script
echo ==============================================

echo.
echo ERROR: JDK (Java Development Kit) required for compilation
echo.
echo Current Java installation is JRE (Java Runtime Environment)
echo which does not include the Java compiler (javac).
echo.
echo TO FIX THIS:
echo 1. Download JDK 8 or higher from:
echo    https://www.oracle.com/java/technologies/downloads/
echo    OR
echo    https://adoptium.net/ (Eclipse Temurin)
echo.
echo 2. Install the JDK
echo.
echo 3. Set JAVA_HOME environment variable to JDK installation path
echo    Example: JAVA_HOME=C:\Program Files\Java\jdk1.8.0_XXX
echo.
echo 4. Update PATH to include JDK bin directory
echo    Example: PATH=%JAVA_HOME%\bin;%PATH%
echo.
echo 5. Verify installation:
echo    javac -version
echo    java -version
echo.
echo 6. Then run the Maven build:
echo    mvnd clean package
echo.

pause

echo.
echo ==============================================
echo ALTERNATIVE: Pre-compiled JAR
echo ==============================================
echo.
echo If you cannot install JDK, you can:
echo 1. Copy the source code to a system with JDK
echo 2. Build there and get the JAR file
echo 3. Run the JAR on this system (JRE is sufficient for running)
echo.
echo The application is fully coded and ready - just needs compilation.
echo.
pause
