package com.utilities.payments.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentStatusDto {
    private String orderId;
    private String paymentLink;
    private double amount;
}
