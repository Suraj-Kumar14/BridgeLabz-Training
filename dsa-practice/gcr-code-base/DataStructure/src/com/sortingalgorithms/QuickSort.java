package com.sortingalgorithms;

public class QuickSort {

	public static void main(String[] args) {
		int arr[] = {33,223,4,32,23,4,32,2,4,32,3422,2};
		
		int n = arr.length;
		quickSort(arr,0,n-1);
		for(int i:arr) {
			System.out.print(i + " ");
		}
	}
	
	public static void quickSort(int arr[], int low ,int high) {
		if(low<high) {
			int pivotIdx = partion(arr,low,high);
			
			//recursive call for smaller, greater and equal elements
			quickSort(arr,low,pivotIdx-1);
			quickSort(arr,pivotIdx+1,high);
		}
	}
	
	public static int partion(int arr[], int low, int high) {
		int pivot = arr[high];
		
		int i=low-1;
		
		for(int j=low;j<=high;j++) {
			if(arr[j]<pivot) {
				i++;
				swap(arr,i,j);
			}
		}
		
		//last swap for pivot in their place
		swap(arr,i+1,high);
		return i+1;
	}
	
	//this method swap
	public static void swap(int arr[], int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}