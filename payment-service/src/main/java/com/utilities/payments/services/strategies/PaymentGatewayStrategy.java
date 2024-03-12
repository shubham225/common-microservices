package com.utilities.payments.services.strategies;

import com.utilities.payments.services.strategies.paymentgateway.PaymentGateway;
import com.utilities.payments.services.strategies.paymentgateway.RazorpayPaymentGateway;
import com.utilities.payments.services.strategies.paymentgateway.StripePaymentGateway;
import org.springframework.stereotype.Service;

@Service
public class PaymentGatewayStrategy {
    final private RazorpayPaymentGateway razorpayPaymentGateway;
    final private StripePaymentGateway stripePaymentGateway;

    PaymentGatewayStrategy(RazorpayPaymentGateway razorpayPaymentGateway,
                           StripePaymentGateway stripePaymentGateway) {
        this.razorpayPaymentGateway = razorpayPaymentGateway;
        this.stripePaymentGateway = stripePaymentGateway;
    }

    public PaymentGateway getBestPaymentGateway() {
        // TODO : need to update the logic to select payment gateway
        return stripePaymentGateway;
    }
}
