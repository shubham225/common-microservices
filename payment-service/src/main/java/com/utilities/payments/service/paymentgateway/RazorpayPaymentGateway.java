package com.utilities.payments.service.paymentgateway;

import org.springframework.stereotype.Component;

@Component
public class RazorpayPaymentGateway implements PaymentGateway{
    @Override
    public String getPaymentLink() {
        return null;
    }
}
