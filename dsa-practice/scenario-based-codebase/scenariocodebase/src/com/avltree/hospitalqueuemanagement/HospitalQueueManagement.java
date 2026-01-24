package com.avltree.hospitalqueuemanagement;

import java.time.LocalTime;

public class HospitalQueueManagement {
	Patient root;
	
	int height(Patient n) {
		return n==null ? 0 : n.getHeight();
	}
	
	int balance(Patient b) {
		return b==null ? 0 : height(root.left)-height(root.right);
	}
	
	//right rotation
	public Patient rightRotate(Patient y) {
		Patient x=y.left;
		Patient T2=x.right;
		x.right=y;
		T2=y.left;
		
		x.setHeight(Math.max(height(x.left),height(x.right)));
		y.setHeight(Math.max(height(y.left),height(y.right)));
		return x;
		
	}
	
	//left rotation
	public Patient leftRotate(Patient x) {
		Patient y=x.right;
		Patient T2=y.left;
		y.left=x;
		T2=x.right;
		
		x.setHeight(Math.max(height(x.left),height(x.right))+1);
		y.setHeight(Math.max(height(y.left),height(y.right))+1);
		return y;
	}
	
	//insert logic
	public Patient insert(Patient root,String name,LocalTime time) {
		if(root==null) {
			return new Patient(name,time);
		}
		
		if(time.isBefore(root.getTime())) {
			root.left=insert(root.left,name,time);
		}else if(time.isAfter(root.getTime())) {
			root.right=insert(root.right,name,time);
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
	
	//patient registration
	public void patientRegistration(String name,LocalTime time) {
		root=insert(root,name,time);
	}
		
	//delete patient
	public Patient delete(Patient root,LocalTime time) {
		if(root==null)
			return root;
			
		if(time.isBefore(root.getTime())) {
			root.left=delete(root.left,time);
		}else if(time.isAfter(root.getTime())) {
			root.right=delete(root.right,time);
		}else {
			if(root.left==null) 
				return root.right;
			if(root.right==null)
				return root.left;
				
			Patient temp=root.right;
			while(temp.left!=null)
				temp=temp.left;
				
			root.setName(temp.getName());
			root.setTime(temp.getTime());
				
			root.right=delete(root.right,temp.getTime());
		}
		return root;
		}
		
		//method to call delete
		public void deleteRecord(LocalTime time) {
			System.out.println("\n---------Patients Details--------");
			root=delete(root,time);
		}
		
		//method to call show 
		public void showPatient() {
			show(root);
		}	
		
		//show event
		public void show(Patient root) {
			if(root==null) {
				return;
			}
			show(root.left);
			System.out.println(root);
			show(root.right);
		}
	
}
