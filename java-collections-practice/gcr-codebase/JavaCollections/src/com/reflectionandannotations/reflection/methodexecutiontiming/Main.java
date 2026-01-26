package com.reflectionandannotations.reflection.methodexecutiontiming;

import java.lang.reflect.Method;

public class Main {

	public static void main(String[] args) throws Exception {
		 Worker w = new Worker();
	        Method m = Worker.class.getDeclaredMethod("doWork");

	        long start = System.nanoTime();
	        m.invoke(w);
	        long end = System.nanoTime();

	        System.out.println("Execution time (ns): " + (end - start));

	}

}
