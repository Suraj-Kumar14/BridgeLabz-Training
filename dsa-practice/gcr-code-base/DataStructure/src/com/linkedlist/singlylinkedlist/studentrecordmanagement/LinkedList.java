package com.linkedlist.singlylinkedlist.studentrecordmanagement;

public class LinkedList {
	private Student head;
	
	//Add at the beginning
	public void addBeginning(int roll,String name,int age,char grade) {
		Student newNode=new Student(roll,name,age,grade);
		newNode.next=head;
		head=newNode;
		System.out.println("Added Student at the beginning!");
	}
	
	//Add at the end
	public void addEnd(int roll,String name,int age,char grade) {
		Student newNode=new Student(roll,name,age,grade);
		if(head==null) {
			head=newNode;
			return;
		}
		Student temp=head;
		while(temp.next!=null) {
			temp=temp.next;
		}
		temp.next=newNode;
		System.out.println("Added student at the End!");
	}
	
	//Added at Specific position
	public void addAtPosition(int roll,String name,int age,char grade,int position) {
		if(position<=1) {
			addBeginning(roll,name,age,grade);
			System.out.println("Added at position");
			return ;
		}
		
		Student newNode=new Student(roll,name,age,grade);
		Student temp=head;
		
		for(int i=1;i<position-1 &&temp!=null;i++) {
			temp=temp.next;
		}
		if(temp==null) {
			System.out.println("Invalid Position!");
			return;
		}
		newNode.next=temp.next;
		temp.next=newNode;
		System.out.println("Added at position!");		
	}
	
	//deleted by number
	public void deleteStduent(int roll) {
		if(head==null) {
			return;
		}
			
		if(head.roll==roll) {
			head = head.next;
			return;
		}
		Student temp = head;
			
		while(temp.next!=null && temp.next.roll!=roll) {
			temp = temp.next;
		}
			
		if(temp.next==null) {
			System.out.println("Stduent not found!");
			return;
		}else {
			temp.next = temp.next.next;
		}
	}
		
		//search student by rollNumber
	public void searchByRoll(int roll) {
		if(head==null) {
			return;
		}	
		Student temp = head;
		while(temp!=null) {
			if(temp.roll==roll) {
				System.out.println("\n----------------------Student found---------------------- ");
	    		printStudent(temp);
				return;
			}
			temp = temp.next;
		}
			
		if(temp==null) {
			System.out.println("Student not found!");
		}
	}
	
	//update student grade
	public void updateGrade(int roll, char newGrage) {
		if(head==null) {
			System.out.println("Student not found!");
			return;
		}
			
		Student temp = head;
			
		while(temp!=null) {
			if(temp.roll==roll) {
				temp.grade = newGrage;
				System.out.println("Grade Updated success.");
				return;
			}
			temp = temp.next;
		}
			
		if(temp==null) {
			System.out.println("Student not found!");
		}
	 }
	
	
	//view all student
	public void viewStudent() {
		if(head==null) {
			System.out.println("Student not found!");
			return;
		}
			
		System.out.println("\n-----------------------View All Stduent--------------------");
		Student temp = head;
		while(temp!=null) {
			printStudent(temp);
			temp = temp.next;
		}
	}
		
	//helper function
	public void printStudent(Student s) {
		System.out.println(
				"Name: "+s.name+
				" | Roll Number: "+s.roll+
				" | cAge: "+s.age+
				" | Grade: "+s.grade
		);
		System.out.println("----------------------------------------------------------");
	}
}
