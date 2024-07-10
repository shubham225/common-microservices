# Payment Service

This Payment Service provides an API to handle payment transactions using Stripe as the payment gateway. It is designed to be a reusable microservice that can be integrated into various applications to handle payments securely and efficiently.

## Features

- **Stripe Integration**: Seamlessly integrates with the Stripe payment gateway.
- **RESTful API**: Provides a set of RESTful endpoints to manage payments.
- **Secure**: Ensures secure transactions with encryption and proper error handling.
- **Extensible**: Can be easily extended to include more payment gateways or additional features.

## Getting Started

### Prerequisites

Before running the service, ensure you have the following installed:

- [Java Development Kit (JDK)](https://openjdk.org/) (version 17 or later)
- [Apache Maven](https://maven.apache.org/)
- A Stripe account and API keys

### Installation

1. Clone the repository:

    ```bash
    git clone https://github.com/shubham225/common-microservices.git
    cd common-microservices/payment-service
    ```

2. Set up environment variables:

   Configure the `STRIPE_SECRET_KEY` environment variable in your system:

    ```bash
    export STRIPE_SECRET_KEY=your_stripe_secret_key
    ```

   Alternatively, you can add this to your shell profile (`~/.bashrc`, `~/.zshrc`, etc.) to set it automatically:

    ```bash
    echo 'export STRIPE_SECRET_KEY=your_stripe_secret_key' >> ~/.bashrc
    source ~/.bashrc
    ```

### Running the Service

To build and run the service, use Maven:

   ```bash
   mvn spring-boot:run
   ```
## API Endpoints

Here are some of the key API endpoints provided by the Payment service:

- **`GET /api/V1/payments/initiatePay`:** Initiates payment and returns the Payment link.