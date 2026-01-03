package com.encapsulationandpolymorphism.LibraryManagementSystem;

public class Book extends LibraryItem implements Reservable {
    private boolean available = true;

    public Book(int itemId, String title, String author) {
        super(itemId, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 21; // days
    }

    @Override
    public void reserveItem() {
        available = false;
    }

    @Override
    public boolean checkAvailability() {
        return available;
    }
}
