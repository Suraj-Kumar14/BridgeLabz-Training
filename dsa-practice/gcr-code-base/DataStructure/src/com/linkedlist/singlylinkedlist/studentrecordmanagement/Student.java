package com.linkedlist.singlylinkedlist.studentrecordmanagement;

public class Student {
		int roll;
		String name;
		int age;
		char grade;
		Student next;
		
		public Student(int roll,String name,int age,char grade) {
			this.roll=roll;
			this.name=name;
			this.age=age;
			this.grade=grade;
			this.next=null;
		}
}
