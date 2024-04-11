## Docker + Java Spring Boot + Gradle Sample Application

This is a sample application that demonstrates some different technologies tied together by Docker.

### Technologies

- Java 20/21
- Spring Boot 3.2.4
- Gradle 8.7
- Docker
- RabbitMQ
- MySQL

### Running the Application

1. Clone the repository
2. Run `docker-compose up --build` in the root directory
3. The application will be available at `http://localhost:8080`


### Application Functions
- The sample application will send a message with a random number to RabbitMQ every 10 seconds
- The message will be consumed by the RabbitMQ listener, multiplied by 2, and saved to the MySQL database