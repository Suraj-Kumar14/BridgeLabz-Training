package com.interfacepractice.markerinterface.cloningprototypeobject;

public class Employee implements Cloneable{
	private int id;
	private String name;
	private String department;
	
	public Employee(int id,String name,String department) {
		this.id=id;
		this.name=name;
		this.department=department;
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException{
		return super.clone();
	}
	
	public void display(){
		System.out.println(id+" | "+name+" | "+department);
	}
}
