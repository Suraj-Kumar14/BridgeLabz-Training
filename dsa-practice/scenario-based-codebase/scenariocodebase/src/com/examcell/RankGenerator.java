package com.examcell;

import java.util.ArrayList;
import java.util.List;

public class RankGenerator {
	List<Student>students=new ArrayList<>();
	
	public void addStudentRecord(Student student) {
		students.add(student);
		System.out.println("Student added successfully..");
	}
	
	public void sortStudent() {
		int start=0, end=students.size()-1;
		
		mergeSort(start,end);
		System.out.println("Student records have been sorted based on marks.");
	}
	
	private void mergeSort(int start,int end) {
		if(start<end) {
			int mid=start+(end-start)/2;
			
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
			if(left.get(i).getScore()>=right.get(j).getScore()) {
				students.set(k++, left.get(i++));
			}else {
				students.set(k++,right.get(j++));
			}
		}
		while(i<n1) {
			students.set(k++,left.get(i++));
		}
		while(j<n2) {
			students.set(k++,right.get(j++));
		}
	}
	
	public void showStudent() {
		System.out.println("------------Student Record------------");
		if(!students.isEmpty()) {
			for(Student s:students) {
				System.out.println(s);
			}
		}else {
			System.out.println("Students record not found!");
		}
		System.out.println();
	}
}
