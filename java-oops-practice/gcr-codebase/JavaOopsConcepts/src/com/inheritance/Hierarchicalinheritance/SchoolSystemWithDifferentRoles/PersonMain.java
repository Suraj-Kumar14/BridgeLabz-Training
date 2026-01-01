package com.inheritance.Hierarchicalinheritance.SchoolSystemWithDifferentRoles;

public class PersonMain {
	
		public static void main(String[] args) {
			Person teacher=new Teacher("Suresh kumar",34,"Teacher","Mathematics");
			Person student=new Student("Suraj Kumar",23,"Student",'A');
			Person staff=new Staff("Vikash",26,"Peon");
			
			//call display role method
			teacher.displayRole();
			student.displayRole();
			staff.displayRole();
		}
}
