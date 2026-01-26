package com.reflectionandannotations.annotations.todoannotation;

public class Service {
	
	@Todo(task = "ATM Software", assignedTo = "@llu")
	public void project1() {
		System.out.println("ATM Software");
	}
	
	
	@Todo(task = "Chat Application", assignedTo = "Arvind", priority = "LOW")
	public void project2() {
		System.out.println("Chat application");
	}
}
