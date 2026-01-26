package com.reflectionandannotations.annotations.importantmark;

import java.lang.reflect.Method;

public class Main {
	public static void main(String[] args) {
		try {
			Class<Service> clazz = Service.class;
			
			Method[] method = clazz.getDeclaredMethods();
			
			for(Method m : method) {
				if(m.isAnnotationPresent(ImportantMethod.class)) {
					ImportantMethod ano = m.getAnnotation(ImportantMethod.class);
					System.out.println(ano.level());
				}
			}
		}
		catch(Exception e) {
			System.out.println(""+e.getMessage());
		}
	}
}
