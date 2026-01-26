package com.reflectionandannotations.annotations.maxlengthannotation;

import java.lang.reflect.Field;

public class User {
	
	@MaxLength(10)
    private String username;

    public User(String username) {
        this.username = username;
        validate();
    }

    private void validate() {
        try {
            Field field = this.getClass().getDeclaredField("username");

            if (field.isAnnotationPresent(MaxLength.class)) {
                MaxLength max = field.getAnnotation(MaxLength.class);

                if (username.length() > max.value()) {
                    throw new IllegalArgumentException(
                        "Username exceeds max length: " + max.value()
                    );
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
	}
}
