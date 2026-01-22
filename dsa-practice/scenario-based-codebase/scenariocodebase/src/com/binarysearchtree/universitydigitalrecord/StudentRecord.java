package com.binarysearchtree.universitydigitalrecord;

public class StudentRecord {
	
	Student root;
	
	//insert student record
	public Student insert(Student root,String name,int rollNo) {
		if(root==null) {
			System.out.println("Student added: "+rollNo);
			return new Student(name,rollNo);
		}
		
		if(rollNo<root.getRollNo()) {
			root.left=insert(root.left,name,rollNo);
		}
		else if(rollNo>root.getRollNo()) {
			root.right=insert(root.right,name,rollNo);
		}else {
			System.out.println("Roll number already exist!");
		}
		
		return root;
	}
	
	//delete student record
	public Student delete(Student root,int rollNo) {
		if(root==null)
			return null;
		if(rollNo<root.getRollNo())
			root.left=delete(root.left,rollNo);
		else if(rollNo>root.getRollNo())
			root.right=delete(root.right,rollNo);
		else {
			if(root.left==null)
				return root.right;
			else if(root.right==null)
				return root.left;
			
			root.setRollNo(minValue(root.right));
			root.right=delete(root.right,root.getRollNo());
		}
		return root;
	}
	
	private int minValue(Student root) {
		int min=root.getRollNo();
		while(root.left!=null) {
			min=root.left.getRollNo();
			root=root.left;
		}
		return min;
	}
	
	//search student by roll no
	public void search(Student root,int rollNo) {
		if(root==null) {
			System.out.println("Student not found!");
			return;
		}
		
		if(root.getRollNo()==rollNo) {
			System.out.println("Student found: "+root.getRollNo()+", Name: "+root.getName());
		}
		else if(rollNo<root.getRollNo()) {
			search(root.left,rollNo);
		}else {
			search(root.right,rollNo);
		}
	}
	
	//display all students(sorted by roll no)
	public void inorder(Student root) {
		if(root!=null) {
			inorder(root.left);
			System.out.println("RollNo: "+root.getRollNo()+", Name: "+root.getName());
			inorder(root.right);
		}
	}
}
