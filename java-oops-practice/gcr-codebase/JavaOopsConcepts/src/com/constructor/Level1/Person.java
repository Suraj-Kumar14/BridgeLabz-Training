package com.constructor.Level1;

public class Person {
	//attributes
	private String name;
	private double height;
	
	//parametrized constructor
	public Person(String name,double height) {
		this.name=name;
		this.height=height;
	}
	
	//copy constructor
	public Person(Person data) {
		this.name=data.name;
		this.height=data.height;
	}
	
	//display personDetails
	public void personDetails() {
		System.out.println("The Name of the person: "+name);
		System.out.println("The height of the person: "+height);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person person1=new Person("Suraj",5.6);  //invoke constructor 
		Person person2=new Person(person1);   //pass object as argument
		
		person1.personDetails();
		System.out.println("Copy constructor calling...");
		person2.personDetails();	
		
	}

}
