package com.shopping.app.domain.service;

import com.shopping.app.domain.model.Price;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Map;

public class PricingService {

    public static final Map<String, BigDecimal> competitorsPrice =
            Map.of("Ipad Pro", BigDecimal.valueOf(1000L));

    Price getDiscountedPrice(String productName, BigDecimal productPrice) {
        final BigDecimal competitorsPriceForTheProduct = competitorsPrice.get(productName);
        final BigDecimal discountedPrice = productPrice.subtract(competitorsPriceForTheProduct.multiply(BigDecimal.TEN).divide(BigDecimal.valueOf(100L)));
        return new Price(discountedPrice, Currency.getInstance("INR"));
    }
}
