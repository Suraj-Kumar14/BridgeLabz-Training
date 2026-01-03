package com.encapsulationandpolymorphism.OnlineFoodDelivery;

public class Order {
    private FoodItem foodItem;

    public Order(FoodItem foodItem) {
        this.foodItem = foodItem;
    }

    public double getFinalAmount() {
        if (foodItem instanceof Discountable) {
            Discountable d = (Discountable) foodItem;
            return foodItem.calculateTotalPrice() - d.applyDiscount();
        }
        return foodItem.calculateTotalPrice();
    }

    public void showOrderDetails() {
        System.out.println(foodItem.getItemDetails());
        System.out.println("Total Price: " + foodItem.calculateTotalPrice());

        if (foodItem instanceof Discountable) {
            Discountable d = (Discountable) foodItem;
            System.out.println(d.getDiscountDetails());
            System.out.println("Final Amount: " + getFinalAmount());
        }
    }
}
