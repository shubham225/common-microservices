package com.utilities.payments.controllers;

import com.utilities.payments.dtos.PaymentRequestDto;
import com.utilities.payments.dtos.PaymentResponseDto;
import com.utilities.payments.services.PaymentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/V1/payments")
public class PaymentController {
    final private PaymentService paymentService;

    PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @RequestMapping(
            method = RequestMethod.POST,
            path = "/initiatePay"
    )
    public PaymentResponseDto initiatePayment(@RequestBody PaymentRequestDto paymentRequest) {
        return paymentService.initiatePayment(paymentRequest.getOrderId());
    }
}
