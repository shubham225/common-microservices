package com.utilities.payments.service.paymentgateway;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentLink;
import com.stripe.model.Price;
import com.stripe.model.Product;
import com.stripe.param.PaymentLinkCreateParams;
import com.stripe.param.PriceCreateParams;
import com.stripe.param.ProductCreateParams;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class StripePaymentGateway implements PaymentGateway{
    @Value("${stripe.secret.key}")
    private String stripeSecretKey;
    @Override
    public String getPaymentLink() {
        Stripe.apiKey = stripeSecretKey;

        ProductCreateParams params =
                ProductCreateParams.builder()
                        .setName("PRD001")
                        .setDescription("My Test Product")
                        .build();

        Product product = null;
        try {
            product = Product.create(params);
        } catch (StripeException e) {
            throw new RuntimeException(e);
        }

        PriceCreateParams paramsPrice =
                PriceCreateParams.builder()
                        .setCurrency("usd")
                        .setUnitAmount(1000L)
                        .setProduct(product.getId())
                        .build();
        Price price = null;
        try {
            price = Price.create(paramsPrice);
        } catch (StripeException e) {
            throw new RuntimeException(e);
        }

        PaymentLinkCreateParams paramsPayLink =
                PaymentLinkCreateParams.builder()
                        .addLineItem(
                                PaymentLinkCreateParams.LineItem.builder()
                                        .setPrice(price.getId())
                                        .setQuantity(1L)
                                        .build()
                        )
                        .build();

        PaymentLink paymentLink = null;
        try {
            paymentLink = PaymentLink.create(paramsPayLink);
        } catch (StripeException e) {
            throw new RuntimeException(e);
        }

        return paymentLink.getUrl();
    }
}
