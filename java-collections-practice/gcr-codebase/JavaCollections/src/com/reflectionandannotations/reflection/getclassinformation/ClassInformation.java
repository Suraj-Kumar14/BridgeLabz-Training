package com.reflectionandannotations.reflection.getclassinformation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ClassInformation {

	public static void main(String[] args) {

		String className="java.lang.Math";
		
		try {
			
			//1.load class
			Class<?>cls=Class.forName(className);
			System.out.println("\nClass: "+cls.getName());
			
			//2. constructor
			System.out.println("\nConstructor: ");
			Constructor<?>[]cons=cls.getDeclaredConstructors();
			for (Constructor<?> constructor : cons) {
                System.out.println("  " + constructor);
            }

			//3. field
			System.out.println("\nFields: ");
			Field[] fields=cls.getDeclaredFields();
			for(Field field:fields) {
				System.out.println(" "+field);
			}
			
			//4. Method
			System.out.println("\nMethod: ");
			Method[] methods=cls.getDeclaredMethods();
			for(Method method: methods) {
				System.out.println(" "+method);
			}
			
		}catch(ClassNotFoundException e) {
			System.out.println("Class not found: "+className);
		}

	}

}
