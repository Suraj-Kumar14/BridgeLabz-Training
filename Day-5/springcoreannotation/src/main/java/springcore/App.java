package springcore;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import springcore.config.AppConfig;
import springcore.model.Student;

public class App {

	public static void main(String [] args) {
		
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		
		System.out.println("Container Started");
		
		Student student = context.getBean(Student.class);
		
		System.out.println(student);
	}
}
