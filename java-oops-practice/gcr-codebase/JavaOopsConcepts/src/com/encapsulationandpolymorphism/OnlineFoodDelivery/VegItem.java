package com.encapsulationandpolymorphism.OnlineFoodDelivery;

public class VegItem extends FoodItem implements Discountable {

    public VegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    @Override
    public double calculateTotalPrice() {
        return price * quantity;
    }

    @Override
    public double applyDiscount() {
        return calculateTotalPrice() * 0.10; 
    }

    @Override
    public String getDiscountDetails() {
        return "10% discount on Veg items";
    }
}
