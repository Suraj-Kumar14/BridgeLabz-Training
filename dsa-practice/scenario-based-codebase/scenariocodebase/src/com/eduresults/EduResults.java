package com.eduresults;

public class EduResults {

	public static void main(String[] args) {
		RankGenerator rank=new RankGenerator();
		
		rank.addStudents(new Student("kali",96));
		rank.addStudents(new Student("Ashu",91));
		rank.addStudents(new Student("aalu",98));
		rank.addStudents(new Student("bholu",89));
		rank.addStudents(new Student("Anshu",90));
		rank.addStudents(new Student("sonu",74));
		rank.addStudents(new Student("monu",78));
		System.out.println();
		System.out.println("Student list before sorting..");
		rank.showStudents();
		rank.sortStudent();
		System.out.println();
		System.out.println("Student list after sorting..");
		rank.showStudents();
		
		
	}

}
