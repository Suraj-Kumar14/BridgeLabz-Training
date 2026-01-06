package com.swiftCartBill;
import java.util.*;

public class Cart implements ICheckout {

    private Map<Product, Integer> items;
    private double totalPrice;

    // Empty cart constructor
    public Cart() {
        items = new HashMap<>();
        totalPrice = 0;
    }

    // Cart with pre-selected items
    public Cart(Map<Product, Integer> items) {
        this.items = items;
        calculateTotal();
    }

    public void addProduct(Product product, int quantity) {
        items.put(product, quantity);
        calculateTotal();
    }

    // Price calculation protected inside Cart only
    private void calculateTotal() {
        totalPrice = 0;
        for (Map.Entry<Product, Integer> entry : items.entrySet()) {
            totalPrice += entry.getKey().getPrice() * entry.getValue();
        }
    }

    @Override
    public double applyDiscount() {
        double discount = 0;

        for (Map.Entry<Product, Integer> entry : items.entrySet()) {
            Product p = entry.getKey();
            int qty = entry.getValue();
            discount += (p.getPrice() * qty) * p.getDiscountRate();
        }
        return totalPrice - discount;
    }

    @Override
    public void generateBill() {
        System.out.println("----- SwiftCart Bill -----");
        for (Map.Entry<Product, Integer> entry : items.entrySet()) {
            System.out.println(entry.getKey().name +
                    " x" + entry.getValue() +
                    " = " + (entry.getKey().getPrice() * entry.getValue()));
        }
        System.out.println("Total Price: " + totalPrice);
        System.out.println("Final Price (After Discount): " + applyDiscount());
    }
}
