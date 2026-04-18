# Use Java 17
FROM eclipse-temurin:17-jdk-jammy

# App jar
ARG JAR_FILE=target/*.jar

# Copy jar
COPY ${JAR_FILE} app.jar

# Run app
ENTRYPOINT ["java","-jar","/app.jar"]