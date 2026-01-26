package com.reflectionandannotations.reflection.dynamicmethodinvocation;

import java.lang.reflect.Method;
import java.util.Scanner;

public class Reflection {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter method name (add/subtract/multiply): ");
		String methodName=sc.next();
		
		System.out.print("Enter first number: ");
		int first=sc.nextInt();

		System.out.print("Enter second number: ");
		int second=sc.nextInt();
		
		Class<?>cls=MathOperations.class;
		 Object obj = cls.getDeclaredConstructor().newInstance();
	
		Method method=cls.getDeclaredMethod(methodName, int.class,int.class);
		method.setAccessible(true);
		
		int result=(int) method.invoke(obj, first,second);
		System.out.println("Result: "+result);
	}
}
