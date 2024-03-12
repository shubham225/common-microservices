package com.utilities.payments.services.strategies.paymentgateway;

import org.springframework.stereotype.Component;

@Component
public class RazorpayPaymentGateway implements PaymentGateway{
    @Override
    public String getPaymentLink() {
        return "DUMMY PAYMENT LINK";
    }
}
