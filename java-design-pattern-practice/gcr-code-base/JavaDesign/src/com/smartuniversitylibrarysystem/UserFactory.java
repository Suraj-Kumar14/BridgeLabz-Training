package com.smartuniversitylibrarysystem;

public class UserFactory {

    public static User createUser(String role) {

        switch (role.toUpperCase()) {
            case "STUDENT":
                return new Student();
            case "FACULTY":
                return new Faculty();
            case "LIBRARIAN":
                return new Librarian();
            default:
                throw new IllegalArgumentException("Unknown user type: " + role);
        }
    }
}
