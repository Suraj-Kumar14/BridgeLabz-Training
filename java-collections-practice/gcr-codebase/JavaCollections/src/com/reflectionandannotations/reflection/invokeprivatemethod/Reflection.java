package com.reflectionandannotations.reflection.invokeprivatemethod;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Reflection {

	public static void main(String[] args) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException, SecurityException {
		Calculator calc=new Calculator();
		
		Class<?>cls=calc.getClass();
		
		Method method=cls.getDeclaredMethod("multiply", int.class,int.class);
		
		method.setAccessible(true);
		int result=(int) method.invoke(calc, 5,10);
		
		System.out.println("Multiply result: "+result);

	}

}
