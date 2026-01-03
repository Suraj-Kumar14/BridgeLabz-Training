package com.encapsulationandpolymorphism.LibraryManagementSystem;

public abstract class LibraryItem {
    protected int itemId;
    protected String title;
    protected String author;

    public LibraryItem(int itemId, String title, String author) {
        this.itemId = itemId;
        this.title = title;
        this.author = author;
    }

    // Abstract method
    public abstract int getLoanDuration();

    // Concrete method
    public String getItemDetails() {
        return "ID: " + itemId + ", Title: " + title + ", Author: " + author;
    }
}
