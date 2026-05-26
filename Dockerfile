# Use JDK 21 base image
FROM eclipse-temurin:21-jdk

# Set working directory
WORKDIR /app

# Copy Maven descriptor
COPY pom.xml .

# Copy source code
COPY src ./src

# Install Maven and build the project
RUN apt-get update && apt-get install -y maven \
    && mvn clean package

# Expose Spring Boot port (default 8080)
EXPOSE 8080


# Run the jar file
ENTRYPOINT ["java", "-jar", "target/gembackend-0.0.1-SNAPSHOT.jar"]
