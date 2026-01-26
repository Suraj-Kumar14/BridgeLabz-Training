package com.reflectionandannotations.reflection.customloggingproxy;

import java.lang.reflect.Proxy;

public class LoggingProxy {

	public static void main(String[] args) {
		 Greeting target = new GreetingImpl();

	     Greeting proxy = (Greeting) Proxy.newProxyInstance(
	           Greeting.class.getClassLoader(),
	           new Class[]{Greeting.class},
	           (p, method, mArgs) -> {
	                System.out.println("Calling: " + method.getName());
	                 return method.invoke(target, mArgs);
	           });

	        proxy.sayHello("Suraj");

	}

}
