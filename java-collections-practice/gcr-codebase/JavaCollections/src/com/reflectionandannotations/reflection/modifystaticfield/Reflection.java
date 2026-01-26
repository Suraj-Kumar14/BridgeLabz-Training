package com.reflectionandannotations.reflection.modifystaticfield;

import java.lang.reflect.Field;

public class Reflection {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
				
		Configuration configure=new Configuration();
		Class<?>cls=Configuration.class;
		
		Field field=cls.getDeclaredField("API_KEY");
		
		field.setAccessible(true);
		field.set(configure, 20);
		
		int result=(int) field.get(configure);
		System.out.println(result);
	}

}
