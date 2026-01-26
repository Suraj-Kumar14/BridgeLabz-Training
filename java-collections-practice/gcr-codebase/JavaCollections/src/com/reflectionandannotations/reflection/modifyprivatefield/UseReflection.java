package com.reflectionandannotations.reflection.modifyprivatefield;

import java.lang.reflect.Field;

public class UseReflection {

	public static void main(String[] args) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {

		Person person=new Person(20);
		
		Class<?>cls=person.getClass();
		System.out.println("Original age: "+person.getAge());
		
		Field field=cls.getDeclaredField("age");
		
		field.setAccessible(true);
		
		field.set(person, 25);
		
		int ageValue=(int) field.get(person);
		System.out.println("Modified age: "+ageValue);
	}

}
