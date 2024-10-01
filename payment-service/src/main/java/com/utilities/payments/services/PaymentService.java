package com.utilities.payments.services;

import com.utilities.payments.dtos.PaymentResponseDto;
import com.utilities.payments.models.Order;
import com.utilities.payments.services.strategies.paymentgateway.PaymentGateway;
import com.utilities.payments.services.strategies.PaymentGatewayStrategy;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    final private PaymentGatewayStrategy paymentGatewayStrategy;

    PaymentService(PaymentGatewayStrategy paymentGatewayStrategy) {
        this.paymentGatewayStrategy = paymentGatewayStrategy;
    }

    public PaymentResponseDto initiatePayment(String orderId) {
        PaymentGateway paymentGateway = paymentGatewayStrategy.getBestPaymentGateway();
        PaymentResponseDto paymentResponseDto = new PaymentResponseDto();
        // Dummy order
        Order order = new Order(orderId,
                        "INR",
                        1000);

        paymentResponseDto.setPaymentLink(paymentGateway.getPaymentLink(order));
        paymentResponseDto.setOrderId(orderId);
        return paymentResponseDto;
    }
}
