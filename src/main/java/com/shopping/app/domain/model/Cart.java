package com.shopping.app.domain.model;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    private String id;
    private Boolean isCheckedOut = false;

    private List<CartItem> cartItems = new ArrayList<>();
    private List<String> cartItemsRemoved = new ArrayList<>();

    public Cart(String id) {
        this.id = id;
    }

    public void add(CartItem cartItem) {
        this.cartItems.add(cartItem);
    }

    public void remove(CartItem cartItem) {
        this.cartItems.remove(cartItem);
        this.cartItemsRemoved.add(cartItem.getProduct().getName());
    }

    public List<CartItem> getCartItems() {
        return new ArrayList<CartItem>(this.cartItems);
    }

    public List<String> getCartItemsRemoved() {
        return cartItemsRemoved;
    }

    public Order checkout() {
        List<Product> products = new ArrayList<>();
        for (CartItem cartItem : cartItems) {
            for (int i = 0; i < cartItem.getQuantity(); i++) {
                products.add(cartItem.getProduct());
            }
        }
        this.isCheckedOut = true;
        return new Order(products);
    }

    public Boolean isCheckedOut() {
        return isCheckedOut;
    }
}
