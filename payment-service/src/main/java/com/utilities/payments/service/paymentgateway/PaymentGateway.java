package com.utilities.payments.service.paymentgateway;

import com.stripe.exception.StripeException;

public interface PaymentGateway {
    String getPaymentLink();
}
