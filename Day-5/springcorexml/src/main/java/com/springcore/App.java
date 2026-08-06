package com.springcore;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springcore.model.Student;

public class App {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	
		System.out.println("Spring Container Loaded Successfully!");

		Student student = (Student) context.getBean("student");
		System.out.println(student);
		
	}
}
