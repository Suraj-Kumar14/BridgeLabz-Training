package com.encapsulationandpolymorphism.OnlineFoodDelivery;

public class NonVegItem extends FoodItem implements Discountable {
    private final double extraCharge = 50.0;

    public NonVegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    @Override
    public double calculateTotalPrice() {
        return (price * quantity) + extraCharge;
    }

    @Override
    public double applyDiscount() {
        return calculateTotalPrice() * 0.05; // 5% discount
    }

    @Override
    public String getDiscountDetails() {
        return "5% discount + extra charge applied";
    }
}
