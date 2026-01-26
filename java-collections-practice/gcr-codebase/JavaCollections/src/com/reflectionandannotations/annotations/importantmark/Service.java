package com.reflectionandannotations.annotations.importantmark;

public class Service {
	
	@ImportantMethod
	public void ProcessOrder() {
		System.out.println("Processing order..");
	}
	
	@ImportantMethod(level="Medium")
	public void ValidateOrder() {
		System.out.println("Validating order..");
	}
	
	public void helperMethod() {
        System.out.println("Helper method");
    }
	
}
