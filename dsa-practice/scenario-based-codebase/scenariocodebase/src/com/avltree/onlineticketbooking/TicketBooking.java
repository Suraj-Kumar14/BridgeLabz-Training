package com.avltree.onlineticketbooking;

import java.time.LocalTime;

public class TicketBooking {
	Ticket root;
	
	public int height(Ticket n) {
		return n==null? 0 : n.getHeight();
	}
	
	public int balance(Ticket b) {
		return b==null? 0 : height(b.left)-height(b.right);
	}
	
	//right rotation
	public Ticket rightRotate(Ticket y) {
		Ticket x=y.left;
		Ticket T2=x.right;
	
		x.right=y;
		y.left=T2;
		
		x.setHeight(Math.max(height(x.left),height(x.right))+1);
		y.setHeight(Math.max(height(y.left),height(y.right)));
		return x;
	}
	
	//left rotation
	public Ticket leftRotate(Ticket x) {
		Ticket y=x.right;
		Ticket T2=y.left;
		
		y.left=x;
		x.right=T2;
		
		x.setHeight(Math.max(height(x.left),height(x.right))+1);
		y.setHeight(Math.max(height(y.left),height(y.right))+1);
		return y;
	}
	
	//insert event
	public Ticket insert(Ticket root,String event,LocalTime time) {
		if(root==null) {
			return new Ticket(event,time);
		}
		if(time.isBefore(root.getTime())) {
			root.left=insert(root.left,event,time);
		}else if(time.isAfter(root.getTime())) {
			root.right=insert(root.right,event,time);
		}else {
			return root;
		}
		
		root.setHeight(Math.max(height(root.left),height(root.right))+1);
		
		int b=balance(root);
		if(b>1 && time.isBefore(root.left.getTime()))
			return rightRotate(root);
		if(b<-1 && time.isAfter(root.right.getTime()))
			return leftRotate(root);
		
		return root;
	}	
	
	//add event
	public void addEvent(String event,LocalTime time) {
		root=insert(root,event,time);
	}
	
	//cancel event
	public Ticket cancel(Ticket root,LocalTime time) {
		if(root==null)
			return root;
		
		if(time.isBefore(root.getTime())) {
			root.left=cancel(root.left,time);
		}else if(time.isAfter(root.getTime())) {
			root.right=cancel(root.right,time);
		}else {
			if(root.left==null) 
				return root.right;
			if(root.right==null)
				return root.left;
			
			Ticket temp=root.right;
			while(temp.left!=null)
				temp=temp.left;
			
			root.setEvent(temp.getEvent());
			root.setTime(temp.getTime());
			
			root.right=cancel(root.right,temp.getTime());
		}
		return root;
	}
	
	//method to call delete
	public void cancelEvent(LocalTime time) {
		System.out.println("\n---------Events--------");
		root=cancel(root,time);
	}
	
	//method to call show 
	public void showTicket() {
		show(root);
	}	
	
	//show event
	public void show(Ticket root) {
		if(root==null) {
			return;
		}
		show(root.left);
		System.out.println(root);
		show(root.right);
	}
}
