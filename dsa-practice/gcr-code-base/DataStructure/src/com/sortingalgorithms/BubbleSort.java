package com.sortingalgorithms;

public class BubbleSort {
	
	public static void main(String[] args) {
		int arr[] = {33,223,4,32,23,4,32,2,4,32,3422,2};
		int n = arr.length;
		
		for(int i=0;i<n;i++) {
			boolean check = false;
			for(int j=0;j<n-1;j++) {
				if(arr[j]>=arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
					check = true;
 				}
			}
			if(!check) {
				break;
			}
		}
		
		for(int i:arr) {
			System.out.print(i + " ");
		}
	}
}
