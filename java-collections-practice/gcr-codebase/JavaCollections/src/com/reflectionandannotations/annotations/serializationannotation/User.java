package com.reflectionandannotations.annotations.serializationannotation;

public class User {

	 @JsonField(name = "user_name")
	    private String username;

	    @JsonField(name = "user_age")
	    private int age;

	    public User(String username, int age) {
	        this.username = username;
	        this.age = age;
	    }
}
