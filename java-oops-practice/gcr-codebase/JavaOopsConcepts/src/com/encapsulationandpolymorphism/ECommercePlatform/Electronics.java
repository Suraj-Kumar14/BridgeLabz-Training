package com.encapsulationandpolymorphism.ECommercePlatform;

public class Electronics extends Product implements Taxable {

    public Electronics(int productId, String name, double price) {
        super(productId, name, price);
    }

    @Override
    public double calculateDiscount() {
        return price * 0.10; // 10% discount
    }

    @Override
    public double calculateTax() {
        return price * 0.18; // 18% tax
    }

    @Override
    public String getTaxDetails() {
        return "Electronics Tax: 18%";
    }
}
