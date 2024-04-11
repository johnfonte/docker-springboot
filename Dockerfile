# Use a base image with Java and Gradle installed
#FROM amazoncorretto:20-al2-jdk AS builder
FROM gradle:8.7-jdk21 as builder

# Set the working directory inside the container
WORKDIR /app

# Copy the Gradle build files
COPY build.gradle .
COPY settings.gradle .

# Copy the source code
COPY . /app

# Build the application
RUN gradle build --no-daemon

# Use a base image with Java already installed
FROM amazoncorretto:20-al2-jdk

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file from the Gradle builder stage
COPY --from=builder /app/build/libs/sampleapp-0.0.1-SNAPSHOT.jar app.jar

# Expose the port that the Spring Boot application will run on
EXPOSE 8080

# Specify the command to run the Spring Boot application when the container starts
CMD ["java", "-jar", "app.jar"]
