package com.eduresults;

import java.util.ArrayList;
import java.util.List;

public class RankGenerator {
	
	List<Student>students=new ArrayList<>();
	
	public void addStudents(Student student) {
		students.add(student);
		System.out.println("Student added.");		
	}
	
	public void sortStudent() {
		int start=0;
		int end=students.size()-1;
		mergeSort(start,end);	
		System.out.println("Student sorted successfully in terms of marks!");
	}
	
	private void mergeSort(int start,int end) {
		if(start<end) {
			int mid=(start+end)/2;
			
			mergeSort(start,mid);
			mergeSort(mid+1,end);
			merge(start,mid,end);			
		}
	}
	
	private void merge(int start,int mid,int end) {
		int n1=mid-start+1;
		int n2=end-mid;
		
		List<Student>left=new ArrayList<>(students.subList(start,mid+1));
		List<Student>right=new ArrayList<>(students.subList(mid+1, end+1));
		
		int i=0,j=0,k=start;
		while(i<n1 && j<n2) {
			if(left.get(i).getMarks()<right.get(j).getMarks()) {
				students.set(k++, left.get(i++));
			}else {
				students.set(k++, right.get(j++));
			}
		}
		while(i<n1) {
			students.set(k++, left.get(i++));
		}
		while(j<n2) {
			students.set(k++,right.get(j++));
		}
	}
	
	public void showStudents() {
		System.out.println("--------------Students Record-----------------");
		if(!students.isEmpty()) {
			for(Student s: students) {
				System.out.println(s);
			}
		}else {
			System.out.println("No data available..");
		}
		System.out.println();
	}
}
