package com.linkedlist.singlylinkedlist.inventoryManagement;

public class InventoryMain {
	
	public static void main(String[] args) {
		LinkedList inventory = new LinkedList();

        // Add items
        inventory.addAtBeginning("Laptop", 101, 5, 55000);
        inventory.addAtEnd("Mouse", 102, 20, 500);
        inventory.addAtEnd("Keyboard", 103, 15, 1500);
        inventory.addAtBeginning("Monitor", 104, 7, 12000);

        System.out.println("\n--- Inventory After Adding Items ---");
        inventory.display();

        // Add at specific position
        inventory.addAtPosition(3, "Printer", 105, 3, 18000);
        System.out.println("\n--- After Adding Printer at Position 3 ---");
        inventory.display();

        // Search operations
        System.out.println("\n--- Search by Item ID (103) ---");
        inventory.searchByID(103);

        System.out.println("\n--- Search by Item Name (Mouse) ---");
        inventory.searchByName("Mouse");

        // Update quantity
        inventory.updateQuantity(102, 25);
        System.out.println("\n--- After Updating Quantity of Mouse ---");
        inventory.display();

        // Remove item
        inventory.removeByID(101);
        System.out.println("\n--- After Removing Item ID 101 ---");
        inventory.display();

        // Calculate total inventory value
        System.out.println("\n--- Total Inventory Value ---");
        inventory.totalInventoryValue();

        // Sort by price
        inventory.sortByPriceAsc();
        System.out.println("\n--- Inventory Sorted by Price (Ascending) ---");
        inventory.display();
	}
}
