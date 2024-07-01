## Introduction

The Product Service is a part of a common microservices project. It provides RESTful APIs for managing product information, including creating, reading, updating, and deleting products.

## Prerequisites
This project is created using Java 17 and Spring boot 3.2.1, maven framework is used as build system.

Before you begin, ensure you have met the following requirements:

- **Java:** Version 17 or later. You can download it from [OpenJDK](https://openjdk.java.net/).
- **Spring Boot:** Version 3.2.1. Check the [official Spring Boot website](https://spring.io/projects/spring-boot) for details.
- **Maven:** The project uses Maven as the build system. Install Maven by following the instructions [here](https://maven.apache.org/install.html).
- **Database**: Set up a MySQL or MariaDB database server. You can install MySQL or MariaDB server locally on your development machine or use a cloud-based database service. You can download MySQL from the [official MySQL website](https://dev.mysql.com/downloads/) or MariaDB from the [official MariaDB website](https://mariadb.org/download/).

## Getting Started

To get a local copy up and running, follow these simple steps:

1. Clone the repository.
   ```bash
   git clone https://github.com/shubham225/common-microservices.git
2. Navigate to the project directory.
    ```bash
   cd common-microservices/product-service
3. Build the project using Maven.
    ```bash
   mvn clean install
4. Run the application.
    ```bash
   mvn spring-boot:run
5. The application will now be accessible at http://localhost:7040. Make sure to configure any additional settings or credentials according to your specific use case.

## Deployment

Follow these steps to deploy the application in a production environment:

1. Build the JAR file:
   ```bash
   mvn clean install
2. Copy the JAR file to the deployment server:
    ```bash
   scp target/product-service-0.0.1.jar user@your-server-ip:/path/to/deployment/
3. SSH into the deployment server:
    ```bash
   ssh user@your-server-ip
4. Run the application:
    ```bash
   java -jar /path/to/deployment/product-service-0.0.1.jar
5. The application will be deployed and accessible on the specified port. Make sure to configure environment-specific settings and secure any sensitive information.

## Environment Variables

The Product Service requires the following environment variables to be set for database connectivity:

- **PRODUCT_DATASOURCE_URL**: This variable should be set to the URL of your server datasource. For example, if you're using a MySQL/MariaDB database for service, the URL might look like `jdbc:mariadb://localhost:3306/your_database_name`.
- **PRODUCT_DB_USER**: Set this variable to the username used to access your database.
- **PRODUCT_DB_PASSWORD**: Set this variable to the password used to access your database.
Make sure to set these environment variables either directly in your development environment or using a configuration file such as `application.properties` or `application.yml` for local development. Additionally, when deploying your Spring Boot application, you can configure these variables through your deployment environment settings.

## API Endpoints

Here are some of the key API endpoints provided by the OAuth2 authorization service:

### Product Management Endpoints
- **`GET /api/V1/products`:** Retrieve a list of products
- **`GET /api/V1/products?sort=asc&limit=10&offset=15`:** Retrieve a list of `10` products sorted in `ascending` order starting from `15`th record
- **`GET /api/V1/products/{id}`:** Retrieve a single product by ID
- **`POST /api/V1/products`:** Create a new product
- **`PUT /api/V1/products/{id}`:** Update an existing product by ID
- **`DELETE /api/V1/products/{id}`:** Delete a product by ID
- **`GET /api/V1/products/{id}/variations`:** Retrieve a list of product variations by Product ID
- **`POST /api/V1/products/{id}/variations`:** Create a new product variations by Product ID.
- **`GET /api/V1/products/{id}/variations/{varId}`:** Retrieve a single product variations by ID
- **`PUT /api/V1/products/{id}/variations/{varId}`:** Update an existing product variations by ID
- **`DELETE /api/V1/products/{id}/variations/{varId}`:** Delete a product variations by ID

### Category Management Endpoints
- **`GET /categories`:** Retrieve a list of product categories.
- **`GET /categories/{id}`:** Retrieve a single product category by ID
- **`POST /categories`:** Create a new product category
- **`PUT /categories/{id}`:** Update an existing product category by ID
- **`DELETE /categories/{id}`:** Delete a product category by ID

### Attributes Management Endpoints
- **`GET /attributes`:** Retrieve a list of product attributes
- **`GET /attributes/{id}`:** Retrieve a single product attribute by ID
- **`POST /attributes`:** Create a new product attribute
- **`PUT /attributes/{id}`:** Update an existing product attribute by ID
- **`DELETE /attributes/{id}`:** Delete a product attribute by ID

- **`GET /attributes/{id}/terms`:** Retrieve a list of attribute terms
- **`GET /attributes/{id}/terms/{termId}`:** Retrieve a single attribute term by ID
- **`POST /attributes/{id}/terms`:** Create a new attribute term
- **`PUT /attributes/{id}/terms/{termId}`:** Update an existing attribute term by ID
- **`DELETE /attributes/{id}/terms/{termId}`:** Delete an attribute term by ID

### Other Endpoints
- **`GET /actuator/health`:** Exposes the health status of the application
- **`GET /actuator/info`:** Provides general information about the application.

## License

This project is licensed under the [MIT License](LICENSE.md).