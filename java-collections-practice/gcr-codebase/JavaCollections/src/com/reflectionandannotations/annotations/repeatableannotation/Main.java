package com.reflectionandannotations.annotations.repeatableannotation;

import java.lang.reflect.Method;

public class Main {
	
	public static void main(String args[]) {
		try {
			Class<TaskService> service = TaskService.class;
			
			Method method = service.getMethod("processTask");
			
			BugReport[] report = method.getAnnotationsByType(BugReport.class);
			for(BugReport re : report) {
				System.out.println("Bug: "+re.description());
			}
			
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
