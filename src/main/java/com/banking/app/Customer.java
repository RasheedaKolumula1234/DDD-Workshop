package com.banking.app;

import java.util.List;

public class Customer {

    private String id;
    private String name;
    private Address address;
    private List<Account> accounts;

    public Customer(String id, String name, Address address, List<Account> accounts) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.accounts = accounts;
    }

    public void updateAddress(Address address) {
        this.address = address;
        this.accounts.forEach(account -> {
            Address accountAddress = new Address(address.getCity());
            account.updateAddress(accountAddress);
        });
    }
}
