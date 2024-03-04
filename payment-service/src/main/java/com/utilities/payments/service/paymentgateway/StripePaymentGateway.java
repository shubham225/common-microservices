package com.utilities.payments.service.paymentgateway;

import org.springframework.stereotype.Component;

@Component
public class StripePaymentGateway implements PaymentGateway{
    @Override
    public String getPaymentLink() {

        return "DUMMY";
    }
}
