package com.utilities.payments.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/V1/payments")
public class PaymentController {
    @RequestMapping(
            method = RequestMethod.POST
    )
    public String initiatePayment() {
        return "DUMMY RESPONSE";
    }
}
