package com.TrafficManager;

public class TrafficManagement {
	private Vehicle head;
	int count=1;
	
	public void addVehicle(String vehicleNo) {
		Vehicle newVehicle=new Vehicle(vehicleNo);
		if(count>10) {
			System.out.println("\nSorry!, Queue Overflow.");
			return;
		}
		
		if(head==null) {
			head=newVehicle;
			newVehicle.next=head;
			System.out.println("Vehicle Added in queue.");
			count++;
			return;
		}
		
		Vehicle temp=head;
		while(temp.next!=head) {
			temp=temp.next;
		}
		temp.next=newVehicle;
		newVehicle.next=head;
		count++;
		System.out.println("Vehicle added in queue.");
	}
	
	//Display vehicle
	public void show() {
		Vehicle temp=head;
		System.out.println("\n------------Vehicle Manager------------");
		while(temp.next!=head) {
			System.out.println("Vehicle No: "+temp.vehicleNo);
			temp=temp.next;
		}
		System.out.println("Vehicle No: "+temp.vehicleNo);
		System.out.println("---------------------------------------");
	}
	
	//remove vehicles
	public void remove(String vehicleNo) {
//		if(count<1) {
//			System.out.println("Queue Underflow");
//			return;
//		}
		if(head==null) {
			System.out.println("Queue underFlow.");
			return;
		}
		
		if(head.next==head && head.vehicleNo.equalsIgnoreCase(vehicleNo)) {
			head=null;
			count--;
			System.out.println("Removed "+head.vehicleNo);
			return;
		}
		Vehicle temp=head;
		while(temp.next!=head) {
			if(temp.next.vehicleNo.equals(vehicleNo)) {
				System.out.println("Removed "+temp.next.vehicleNo);
				temp.next=temp.next.next;
				head=temp.next;
				count--;
				return;
			}	
			temp=temp.next;
		}
		if(temp.next.vehicleNo.equalsIgnoreCase(vehicleNo)) {
			System.out.println("Removed: "+temp.next.vehicleNo);
			temp.next=temp.next.next;
			head=temp.next.next;
			count--;			
			return;
		}
		System.out.println("Vehicle Not found!");
	}
}