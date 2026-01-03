package com.encapsulationandpolymorphism.LibraryManagementSystem;

public class Magazine extends LibraryItem implements Reservable {
    private boolean available = true;

    public Magazine(int itemId, String title, String author) {
        super(itemId, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 7;
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
