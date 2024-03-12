package com.utilities.payments.services;

import com.utilities.payments.dtos.PaymentResponseDto;
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
        paymentResponseDto.setPaymentLink(paymentGateway.getPaymentLink());
        paymentResponseDto.setOrderId(orderId);
        return paymentResponseDto;
    }
}
