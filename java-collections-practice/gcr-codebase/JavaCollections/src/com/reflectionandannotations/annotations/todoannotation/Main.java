package com.reflectionandannotations.annotations.todoannotation;

import java.lang.reflect.Method;

public class Main {

	public static void main(String[] args) {
		
		Class<?>cls=Service.class;
		
		Method[] method=cls.getDeclaredMethods();
		
		for(Method m: method) {
			if(m.isAnnotationPresent(Todo.class)) {
				Todo todo= m.getAnnotation(Todo.class);
				
			System.out.println(todo.task());
			System.out.println(todo.assignedTo());
			System.out.println(todo.priority());
			}
		}

	}

}
