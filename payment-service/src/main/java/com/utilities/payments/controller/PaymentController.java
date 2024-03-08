package com.utilities.payments.controller;

import com.utilities.payments.service.PaymentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/V1/payments")
public class PaymentController {
    final private PaymentService paymentService;

    PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @RequestMapping(
            method = RequestMethod.GET,
            path = "/{orderId}"
    )
    public String initiatePayment(@PathVariable String orderId) {
        return paymentService.initiatePayment(orderId);
    }
}
