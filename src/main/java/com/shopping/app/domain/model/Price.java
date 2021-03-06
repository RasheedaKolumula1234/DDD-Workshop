package com.shopping.app.domain.model;

import java.math.BigDecimal;
import java.util.Currency;

public class Price {

    private BigDecimal amount;
    private Currency currency;

    public Price(BigDecimal amount, Currency currency) {
        this.amount = amount;
        this.currency = currency;
    }
}
