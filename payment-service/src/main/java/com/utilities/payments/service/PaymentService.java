package com.utilities.payments.service;

import com.utilities.payments.dto.PaymentStatusDto;
import com.utilities.payments.service.paymentgateway.PaymentGateway;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    final private PaymentGatewayStrategy paymentGatewayStrategy;

    PaymentService(PaymentGatewayStrategy paymentGatewayStrategy) {
        this.paymentGatewayStrategy = paymentGatewayStrategy;
    }

    public PaymentStatusDto initiatePayment(String orderId) {
        PaymentGateway paymentGateway = paymentGatewayStrategy.getBestPaymentGateway();
        PaymentStatusDto paymentStatusDto = new PaymentStatusDto();
        paymentStatusDto.setPaymentLink(paymentGateway.getPaymentLink());
        paymentStatusDto.setOrderId(orderId);
        return paymentStatusDto;
    }
}
