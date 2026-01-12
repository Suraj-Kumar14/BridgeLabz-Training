package com.TrainCompanion;

public class TrainManagement {
	private Compartment head,prev;
	
	//Insert compartment in LinkedList
	public void insertCompartment(String compartmentName) {
		Compartment newTrain=new Compartment(compartmentName);
		if(head==null) {
			head=newTrain;
			return;
		}
		Compartment temp=head;
		while(temp.next!=null) {
			temp=temp.next;
		}
		temp.next=newTrain;
		newTrain.prev=temp;
	}
	
	//Remove compartment
	public void removeCompartment(String compartmentName) {
		System.out.println("-------------Remove compartment-------------");
		Compartment temp=head;
		if(head==null) {
			System.out.println("Empty linkedlist!");
			System.out.println("--------------------------------------------\n");
			return;
		}
		while(temp!=null) {
			if(temp.compartmentName.equalsIgnoreCase(compartmentName)) {
				if(temp.prev!=null)
				{
				temp.prev.next=temp.next;
				}else {
					head=temp.next;
				}
				if(temp.next!=null) {
					temp.next.prev=temp.prev;
				}
				System.out.println("Removed: "+compartmentName);
				System.out.println("--------------------------------------------\n");
				return;
			}
		
			temp=temp.next;
		}
		System.out.println("Compartment not found!");
		System.out.println("--------------------------------------------\n");
	}
	
	//check compartment in forward direction
	public void forward(String compartmentName) {
		Compartment temp=head;
		int index=0;
		System.out.println("\n-----Search pantry in forward direction-----");
		if(head==null) {
			System.out.println("Empty linkedlist!");
			System.out.println("--------------------------------------------\n");
			return;
		}
		while(temp!=null) {
			if(temp.compartmentName.equals(compartmentName)) {
				System.out.println("Pantry is at "+(index+1)+ " position in forward direction");
				System.out.println("--------------------------------------------\n");
				return;
			}
			temp=temp.next;
			index++;
		}
		System.out.println("Pantry not found!");
		System.out.println("--------------------------------------------\n");
	}
	
	//check compartment in backward direction
	public void backward(String compartmentName) {
		Compartment temp=head;
		System.out.println("\n-----Search pantry in backward direction-----");
		int index=0;
		if(head==null) {
			System.out.println("Empty linkedlist");
			System.out.println("--------------------------------------------\n");
			return;
		}
		
		//move to last node
			while(temp.next!=null) {
				temp=temp.next;
			}
			
			while(temp!=null) {
				if(temp.compartmentName.equals(compartmentName)) {
					System.out.println("Pantry is at "+(index+1)+ " position in backward direction");
					System.out.println("--------------------------------------------\n");
					return;
				}
				temp=temp.prev;
				index++;
			}
		System.out.println("Pantry not found!");
		System.out.println("--------------------------------------------\n");
	}
	
	public void displayCompartment() {
		System.out.println("--------Train Companion---------");
		Compartment temp=head;
		System.out.print("Engine-->");
		while(temp!=null) {
			System.out.print(temp.compartmentName+"-->");
			temp=temp.next;
		}
		System.out.print("Engine");
		System.out.println("\n---------------------------------\n");
		
	}
}
