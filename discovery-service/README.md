# Discovery Service

This Discovery Service is implemented using Spring Boot and serves as a Netflix Eureka service registry. It allows microservices to register themselves dynamically and facilitates service discovery within a microservices architecture.

## Features

- **Service Registration**: Allows microservices to register themselves for discovery.
- **Service Discovery**: Enables microservices to locate and communicate with one another.
- **High Availability**: Can be configured for high availability by running multiple instances.
- **RESTful API**: Provides endpoints to manage and query registered services.

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
    cd common-microservices/discovery-service
    ```

2. Build the project using Maven:

    ```bash
    mvn clean install
    ```

### Running the Service

To start the Discovery Service, run:

```bash
mvn spring-boot:run