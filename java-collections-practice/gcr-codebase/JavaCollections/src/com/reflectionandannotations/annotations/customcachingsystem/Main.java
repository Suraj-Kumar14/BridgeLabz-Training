package com.reflectionandannotations.annotations.customcachingsystem;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class Main {
	
	 static Map<Integer, Integer> cache = new HashMap<>();

	    public static void main(String[] args) throws Exception {

	        Calculator calc = new Calculator();
	        Method m = Calculator.class.getMethod("square", int.class);

	        System.out.println(invoke(calc, m, 5));
	        System.out.println(invoke(calc, m, 5)); // cached
	    }

	    static Object invoke(Object obj, Method m, int arg) throws Exception {

	        if (m.isAnnotationPresent(CacheResult.class)) {

	            if (cache.containsKey(arg)) {
	                System.out.println("Returning cached result");
	                return cache.get(arg);
	            }

	            Object result = m.invoke(obj, arg);
	            cache.put(arg, (Integer) result);
	            return result;
	        }

	        return m.invoke(obj, arg);
	    }
}
