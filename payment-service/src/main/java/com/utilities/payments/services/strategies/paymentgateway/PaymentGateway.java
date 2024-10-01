package com.utilities.payments.services.strategies.paymentgateway;

import com.utilities.payments.models.Order;

public interface PaymentGateway {
    String getPaymentLink(Order order);
}
