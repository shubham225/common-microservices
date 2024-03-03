package com.utilities.payments.service;

import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    public String initiatePayment(String orderId) {
        return "initiating Payment for " + orderId;
    }
}
