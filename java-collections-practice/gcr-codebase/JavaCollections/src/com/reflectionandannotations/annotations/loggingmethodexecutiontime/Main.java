package com.reflectionandannotations.annotations.loggingmethodexecutiontime;

import java.lang.reflect.Method;

public class Main {

	public static void main(String[] args) throws Exception {
		try {
			
			Class<?>cls=CompareTime.class;
			CompareTime time=new CompareTime();
			Method[] method=cls.getDeclaredMethods();
			for(Method m: method) {
				if(m.isAnnotationPresent(LogExecutionTime.class)) {
				long start=System.nanoTime();
				m.invoke(time);
				long end=System.nanoTime();
				
				long duration=end-start;
				
				System.out.println("Method: " +m.getName()+"   Execution Time: "+duration+" ns");
			}
		}
	}catch(Exception e) {
		System.out.println(e.getMessage());
	}
	}
}
