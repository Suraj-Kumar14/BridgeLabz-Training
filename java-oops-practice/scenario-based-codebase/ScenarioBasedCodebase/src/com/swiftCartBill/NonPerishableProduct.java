package com.swiftCartBill;

public class NonPerishableProduct extends Product {

    public NonPerishableProduct(String name, double price) {
        super(name, price, "Non-Perishable");
    }

    @Override
    public double getDiscountRate() {
        return 0.05; // 5% discount
    }
}
