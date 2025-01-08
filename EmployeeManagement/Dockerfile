# Stage 1: Build
FROM maven:3.8.4-openjdk-17 AS build

WORKDIR /app

# Copy the Maven descriptor and resolve dependencies
COPY pom.xml .
RUN mvn dependency:go-offline

# Copy source code and build the application
COPY src ./src
RUN mvn clean package -DskipTests

# Stage 2: Runtime
FROM openjdk:17-jdk-slim

WORKDIR /app

# Copy the JAR file from the build stage
COPY --from=build /app/target/EmployeeManagement-0.0.1-SNAPSHOT.jar .

# Expose the application's port
EXPOSE 8080

# Set the entrypoint to run the JAR file
ENTRYPOINT ["java", "-jar", "EmployeeManagement-0.0.1-SNAPSHOT.jar"]
