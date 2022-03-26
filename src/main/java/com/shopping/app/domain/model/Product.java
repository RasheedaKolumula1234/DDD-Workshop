package com.shopping.app.domain.model;

import com.shopping.app.domain.model.Price;

public class Product {

    private String name;
    private Price price;

    public Product(String name, Price price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }
}
