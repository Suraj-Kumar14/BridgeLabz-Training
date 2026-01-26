package com.reflectionandannotations.annotations.customannotation;

public class TaskManager {
	
	@TaskInfo(priority=1,assignTo="Allu")
	
	public void createTask() {
		System.out.println("Task Created.");
	}
	
}
