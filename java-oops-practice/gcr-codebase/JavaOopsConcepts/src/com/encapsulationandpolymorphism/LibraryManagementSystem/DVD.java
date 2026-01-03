package com.encapsulationandpolymorphism.LibraryManagementSystem;

public class DVD extends LibraryItem implements Reservable {
    private boolean available = true;

    public DVD(int itemId, String title, String author) {
        super(itemId, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 3;
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
