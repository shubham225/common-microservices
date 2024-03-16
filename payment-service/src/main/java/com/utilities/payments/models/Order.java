package com.utilities.payments.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.print.DocFlavor;

@Getter
@Setter
@AllArgsConstructor
public class Order {
    // Add required order details
    String orderId;
    String currency;
    long amount;
}
