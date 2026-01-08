package com.sortingalgorithms;

public class MergeSort {

	public static void main(String[] args) {
		//created array 
		int arr[] = {33,223,4,32,23,4,32,2,4,32,3422,2};
		int n = arr.length;
		
		//call method
		int finalAnswer[] = operationMerge(arr,0,n-1);
		
		//display
		for(int i:finalAnswer) {
			System.out.print(i + " ");
		}
	}
	
	//method to perform merge sort
	public static int[] operationMerge(int arr[], int l, int r) {
		if(l==r) {
			return new int[] {arr[l]};
		}
		int mid = (l+r)/2;
		
		//left half
		int arr1[] = operationMerge(arr,l,mid);
		
		//right half
		int arr2[] = operationMerge(arr,mid+1,r);
		
		//call merge
		return merge(arr1,arr2);
	}
	
	public static int[] merge(int left[], int right[]) {
		
		int result[] = new int[left.length+right.length];
		int i=0, j = 0, k=0;
		
		while(i<left.length && j<right.length) {
			if(left[i]<right[j]) {
				result[k++] = left[i++];
			}
			else {
				result[k++] = right[j++];
			}
		}
		
		while(i<left.length) {
			result[k++] = left[i++];
		}
		
		while(j<right.length) {
			result[k++] = right[j++];
		}
		return result;
 	}
}