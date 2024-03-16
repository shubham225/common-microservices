package com.utilities.payments.services.strategies.paymentgateway;

import com.utilities.payments.models.Order;
import org.springframework.stereotype.Component;

@Component
public class RazorpayPaymentGateway implements PaymentGateway{
    @Override
    public String getPaymentLink(Order order) {
        return "DUMMY PAYMENT LINK";
    }
}
