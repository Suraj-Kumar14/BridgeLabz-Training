package com.sortingalgorithms;

public class SelectionSort {

	public static void main(String[] args) {
		int arr[]= {33,223,4,33,23,2,4,54,43,7};
		int n=arr.length;
		
		//call method
		selection(arr);
		
		//display
		for(int i:arr) {
			System.out.print(i+" ");
		}
	}
	
	public static void selection(int[] arr) {
		for(int i=0;i<arr.length;i++) {
			int minIdx=i;
			
			//find the minimum element index
			for(int j=i+1;j<arr.length;j++) {
				if(arr[j]<arr[minIdx]) {
					minIdx=j;
				}
			}
			
			//swap
			int temp=arr[minIdx];
			arr[minIdx]=arr[i];
			arr[i]=temp;
		}
	}

}
