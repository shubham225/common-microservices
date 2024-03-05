package com.utilities.payments.service;

import com.utilities.payments.service.paymentgateway.PaymentGateway;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    final private PaymentGatewayStrategy paymentGatewayStrategy;

    PaymentService(PaymentGatewayStrategy paymentGatewayStrategy) {
        this.paymentGatewayStrategy = paymentGatewayStrategy;
    }

    public String initiatePayment(String orderId) {
        PaymentGateway paymentGateway = paymentGatewayStrategy.getBestPaymentGateway();
        return paymentGateway.getPaymentLink();
    }
}
