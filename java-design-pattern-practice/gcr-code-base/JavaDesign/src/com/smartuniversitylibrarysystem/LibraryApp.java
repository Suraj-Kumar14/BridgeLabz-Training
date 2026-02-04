package com.smartuniversitylibrarysystem;

public class LibraryApp {

    public static void main(String[] args) {

        // Singleton
        LibraryCatalog catalog = LibraryCatalog.getInstance();

        // Observer
        catalog.addObserver(new UserNotification("Suraj"));
        catalog.addObserver(new UserNotification("Amit"));

        // Builder
        Book book1 = new Book.BookBuilder("Data Structures by Cormen")
                .author("Thomas H. Cormen")
                .edition("3rd")
                .genre("Computer Science")
                .publisher("MIT Press")
                .build();

        // Add book → triggers notifications
        catalog.addBook(book1);

        // Factory
        User student = UserFactory.createUser("student");
        User faculty = UserFactory.createUser("faculty");
        User librarian = UserFactory.createUser("librarian");

        student.getPrivileges();
        faculty.getPrivileges();
        librarian.getPrivileges();
    }
}
