package com.AmbulanceRoute;

public class AmbulanceRoute {
	private HospitalUnit head;
	
	public void addUnit(String name,boolean available) {
		HospitalUnit newUnit=new HospitalUnit(name,available);
		if(head==null) {
			head=newUnit;
			head.next=head;
		}else {
			HospitalUnit temp=head;
			while(temp.next!=head) {
				temp=temp.next;
			}
			temp.next=newUnit;
			newUnit.next=head;
		}
	}
	
	//Remove unit
	public void removeUnit(String name) {
		if(head==null) {
			return;
		}
		HospitalUnit curr=head, prev=null;
		
		do {
			if(curr.getName().equalsIgnoreCase(name)) {
				if(prev!=null) {
					prev.next=curr.next;
				}else {
					HospitalUnit temp=head;
					while(temp.next!=head) {
						temp=temp.next;
					 }		
						head=head.next;
						temp.next=head;
				  }
					System.out.println(name+" is under maintainance and removed.");
					return;
		    	}	
				prev=curr;
				curr=curr.next;
		   }while(curr!=head);
	}
	
	//find nearest available unit
	public void findAvailable() {
		if(head==null) {
			System.out.println("No hospital units available!");
			return;
		}
		HospitalUnit temp=head;
		do {
			if(temp.available) {
				System.out.println("Redirecting patient to "+temp.getName());
				return;
		     }
			temp=temp.next;				
		}while(temp!=head);
		System.out.println("No available units found!");
	}
	
	//display route
	public void displayRoute() {
		if(head==null) {
			System.out.println("Hospital not found!");
			return;
		}
		HospitalUnit temp=head;
		do {
			System.out.print(temp.getName()+" --> ");
			temp=temp.next;
		}while(temp!=head);
		System.out.println("(back to "+head.getName()+")");
	}
}
	

