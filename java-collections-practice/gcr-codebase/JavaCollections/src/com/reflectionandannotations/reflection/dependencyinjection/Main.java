package com.reflectionandannotations.reflection.dependencyinjection;

import java.lang.reflect.Field;

public class Main {

	public static void main(String[] args) throws Exception {
		  Controller controller = new Controller();

	        for (Field field : controller.getClass().getDeclaredFields()) {
	            if (field.isAnnotationPresent(Inject.class)) {
	                field.setAccessible(true);
	                Object dep = field.getType()
	                        .getDeclaredConstructor()
	                        .newInstance();
	                field.set(controller, dep);
	            }
	        }

	        controller.process();
	}

}
