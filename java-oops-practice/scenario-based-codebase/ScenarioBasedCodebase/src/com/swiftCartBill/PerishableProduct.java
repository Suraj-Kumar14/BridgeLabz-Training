package com.swiftCartBill;

public class PerishableProduct extends Product {

    public PerishableProduct(String name, double price) {
        super(name, price, "Perishable");
    }

    @Override
    public double getDiscountRate() {
        return 0.10; // 10% discount
    }
}