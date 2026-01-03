package com.encapsulationandpolymorphism.LibraryManagementSystem;

public class LibraryTest {
    public static void main(String[] args) {
        LibraryItem item1 = new Book(1, "1984", "Abhijeet kumar");
        LibraryItem item2 = new Magazine(2, "Time", "Editorial Team");
        LibraryItem item3 = new DVD(3, "Inception", "Surajbhan singh");

        System.out.println(item1.getItemDetails() + " | Loan: " + item1.getLoanDuration());
        System.out.println(item2.getItemDetails() + " | Loan: " + item2.getLoanDuration());
        System.out.println(item3.getItemDetails() + " | Loan: " + item3.getLoanDuration());
    }
}
