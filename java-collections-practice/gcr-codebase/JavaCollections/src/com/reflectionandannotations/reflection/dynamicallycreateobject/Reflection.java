package com.reflectionandannotations.reflection.dynamicallycreateobject;

import java.lang.reflect.Constructor;

public class Reflection {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Class<?>cls=Student.class;
		
		Constructor<?>cons=cls.getDeclaredConstructor(String.class);
		
		Student student=(Student) cons.newInstance("Allu");
		student.show();
	}

}
