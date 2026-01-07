package com.sortingalgorithms;

public class InsetionSortEmployeeID {
	
	public static void insertionSort(int[] empIds) {
		int n=empIds.length;
		
		for(int i=1;i<n;i++) {
			int key=empIds[i];
			int j=i-1;
			
			while(j>=0 && empIds[j]>key) {
				empIds[j+1]=empIds[j];
				j--;
			}
			empIds[j+1]=key;
		}
	}
	
	public static void printArray(int[] arr) {
		for(int id: arr) {
			System.out.print(id+" ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		int[] employeeIds= {105,102,110,101,108};
		
		System.out.println("Before sorting: ");
		printArray(employeeIds);
		
		insertionSort(employeeIds);
		
		System.out.println("After Sorting: ");
		printArray(employeeIds);
	}
}
