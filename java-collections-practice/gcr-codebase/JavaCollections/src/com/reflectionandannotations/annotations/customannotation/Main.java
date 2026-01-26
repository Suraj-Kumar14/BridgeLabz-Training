package com.reflectionandannotations.annotations.customannotation;

import java.lang.reflect.Method;

public class Main {

	public static void main(String[] args) {
		try {
			Class<TaskManager> clazz = TaskManager.class;
			
			Method method = clazz.getMethod("createTask");
			
			//check annotation 
			if(method.isAnnotationPresent(TaskInfo.class)) {
				TaskInfo info = method.getAnnotation(TaskInfo.class);
				
				//read annotation
				System.out.println("Priority: "+info.priority());
				System.out.println("Assigned To: "+info.assignTo());
			}
			
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
