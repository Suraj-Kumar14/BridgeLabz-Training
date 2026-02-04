package com.smartuniversitylibrarysystem;

public class UserNotification implements Observer {

    private String userName;

    public UserNotification(String userName) {
        this.userName = userName;
    }

    @Override
    public void update(Book book) {
        System.out.println(
            "Notification to " + userName + ": New book added -> " + book.getTitle()
        );
    }
}
