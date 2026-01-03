package com.encapsulationandpolymorphism.OnlineFoodDelivery;

public abstract class FoodItem {
    protected String itemName;
    protected double price;
    protected int quantity;

    public FoodItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    // Abstract method
    public abstract double calculateTotalPrice();

    // Concrete method
    public String getItemDetails() {
        return "Item: " + itemName + 
               ", Price: " + price + 
               ", Quantity: " + quantity;
    }
}
