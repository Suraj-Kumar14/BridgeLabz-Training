package com.linkedlist.singlylinkedlist.inventoryManagement;

public class LinkedList {

    Inventory head;

    // Add at Beginning
    public void addAtBeginning(String n, int id, int q, double p) {
        Inventory newNode = new Inventory(n, id, q, p);
        newNode.next = head;
        head = newNode;
    }

    // Add at End
    public void addAtEnd(String n, int id, int q, double p) {
        Inventory newNode = new Inventory(n, id, q, p);

        if (head == null) {
            head = newNode;
            return;
        }

        Inventory temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    // Add at Specific Position (1-based index)
    public void addAtPosition(int pos, String n, int id, int q, double p) {

        if (pos == 1) {
            addAtBeginning(n, id, q, p);
            return;
        }

        Inventory newNode = new Inventory(n, id, q, p);
        Inventory temp = head;

        for (int i = 1; i < pos - 1 && temp != null; i++) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Invalid position");
            return;
        }

        newNode.next = temp.next;
        temp.next = newNode;
    }

    // 4️⃣ Remove item by Item ID
    public void removeByID(int id) {

        if (head == null) {
            System.out.println("Inventory is empty");
            return;
        }

        if (head.itemID == id) {
            System.out.println("Removed: " + head.itemName);
            head = head.next;
            return;
        }

        Inventory temp = head;
        while (temp.next != null) {
            if (temp.next.itemID == id) {
                System.out.println("Removed: " + temp.next.itemName);
                temp.next = temp.next.next;
                return;
            }
            temp = temp.next;
        }

        System.out.println("Item not found");
    }

    //Update quantity by Item ID
    public void updateQuantity(int id, int newQty) {
        Inventory temp = head;

        while (temp != null) {
            if (temp.itemID == id) {
                temp.Quantity = newQty;
                System.out.println("Quantity updated for: " + temp.itemName);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item not found");
    }

    // Search by Item ID
    public void searchByID(int id) {
        Inventory temp = head;

        while (temp != null) {
            if (temp.itemID == id) {
                printItem(temp);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item not found");
    }

    // Search by Item Name
    public void searchByName(String name) {
        Inventory temp = head;

        while (temp != null) {
            if (temp.itemName.equalsIgnoreCase(name)) {
                printItem(temp);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item not found");
    }

    // Calculate total inventory value
    public void totalInventoryValue() {
        Inventory temp = head;
        double total = 0;

        while (temp != null) {
            total += temp.Price * temp.Quantity;
            temp = temp.next;
        }

        System.out.println("Total Inventory Value = ₹" + total);
    }

    // Display Inventory
    public void display() {
        Inventory temp = head;

        if (temp == null) {
            System.out.println("Inventory empty");
            return;
        }

        while (temp != null) {
            printItem(temp);
            temp = temp.next;
        }
    }

    //Sort by Price (Ascending)
    public void sortByPriceAsc() {
        for (Inventory i = head; i != null; i = i.next) {
            for (Inventory j = i.next; j != null; j = j.next) {
                if (i.Price > j.Price) {
                    swapData(i, j);
                }
            }
        }
    }

    // Helper methods
    private void swapData(Inventory a, Inventory b) {
        String name = a.itemName;
        int id = a.itemID;
        int q = a.Quantity;
        double p = a.Price;

        a.itemName = b.itemName;
        a.itemID = b.itemID;
        a.Quantity = b.Quantity;
        a.Price = b.Price;

        b.itemName = name;
        b.itemID = id;
        b.Quantity = q;
        b.Price = p;
    }

    private void printItem(Inventory i) {
        System.out.println(
            "ID: " + i.itemID +
            ", Name: " + i.itemName +
            ", Qty: " + i.Quantity +
            ", Price: " + i.Price
        );
    }
}