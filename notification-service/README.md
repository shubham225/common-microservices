# Notification Service

This Notification Service is implemented using Spring Boot and provides functionality to send notifications to users through various channels. It serves as a microservice in a larger architecture, handling notification tasks efficiently and reliably.

## Features

- **Multi-Channel Notifications**: Supports sending notifications via different channels such as email, SMS, and push notifications.
- **Asynchronous Processing**: Utilizes asynchronous processing to handle large volumes of notifications without blocking.
- **Secure Communication**: Ensures secure communication with external services and clients.

## Technologies Used

- Java 17
- Spring Boot
- Maven

## Getting Started

### Prerequisites

Before running the service, ensure you have the following installed:

- [Java Development Kit (JDK) 17](https://www.oracle.com/java/technologies/javase-jdk17-downloads.html)
- [Apache Maven](https://maven.apache.org/)

### Installation

1. Clone the repository:

    ```bash
    git clone https://github.com/shubham225/common-microservices.git
    cd common-microservices/notification-service
    ```

2. Build the project using Maven:

    ```bash
    mvn clean install
    ```

### Configuration

1. Configure the application properties (`src/main/resources/application.properties`) or YAML (`src/main/resources/application.yml`) for your specific environment and requirements.

   Example YAML (`src/main/resources/application.yml`):

    ```yaml
    server:
      port: 8082

    spring:
      application:
        name: notification-service

    email:
      username: ${EMAIL_ID}
      password: ${EMAIL_PASSWD}
    ```

   In this example:
    - `server.port`: Specifies the port on which the service will run.
    - `spring.application.name`: Sets the name of the application in Spring context.
    - `email.username` and `email.password`: These variables are placeholders that will be resolved from environment variables `EMAIL_ID` and `EMAIL_PASSWD`.

2. Set the environment variables in your operating system or deployment environment:

    ```bash
    export EMAIL_ID=your_email@example.com
    export EMAIL_PASSWD=your_email_password
    ```

   Make sure to replace `your_email@example.com` and `your_email_password` with your actual email credentials.

### Running the Service

To start the Notification Service, run:

```bash
mvn spring-boot:run
```

## API Endpoints

Here are some of the key API endpoints provided by the Notification service:

- **`GET /api/V1/notify`:** Sends a mail to the specified receiver in request body.