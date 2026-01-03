package com.encapsulationandpolymorphism.OnlineFoodDelivery;

public class FoodDelivery {
    public static void main(String[] args) {

        FoodItem item1 = new VegItem("Paneer Pizza", 250, 2);
        FoodItem item2 = new NonVegItem("Chicken Burger", 180, 2);

        Order order1 = new Order(item1);
        Order order2 = new Order(item2);

        order1.showOrderDetails();
        System.out.println("---------------");
        order2.showOrderDetails();
    }
}
