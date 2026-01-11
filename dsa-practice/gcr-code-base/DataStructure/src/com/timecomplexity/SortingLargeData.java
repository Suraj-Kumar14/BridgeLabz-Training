package com.timecomplexity;
import java.util.*;

public class SortingLargeData {
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.println("Enter the size of array: ");
		int n = sc.nextInt();
		
		int arr1[] = new int[n];
		for(int i=0;i<n;i++) {
			arr1[i] = n-i;
		}		
		
		//bubbleSort
		long start_bubbleSort_time = System.nanoTime();
		bubbleSort(arr1);
		long end_bubbleSort_time = System.nanoTime();
		System.out.println("Bubble Sort time takne	: "+(end_bubbleSort_time-start_bubbleSort_time));
		
		
		//mergeSort
		long start_mergeSort_time = System.nanoTime();
	
		long end_mergeSort_time = System.nanoTime();
		System.out.println("Merge Sort time taken	: "+(end_mergeSort_time-start_mergeSort_time));
		
		//quickSort
		long start_quickSort_time = System.nanoTime();
		quickSort(arr1,0,arr1.length-1);
		long end_quickSort_time = System.nanoTime();
		System.out.println("Quick Sort time taken	: "+(end_quickSort_time-start_quickSort_time));
	}
	
	public static void bubbleSort(int arr1[]) {
		for(int i=0;i<arr1.length-1;i++) {
			for(int j=0;j<arr1.length-i-1;j++) {
				if(arr1[j]>arr1[j+1]) {
					int temp = arr1[j];
					arr1[j] = arr1[j+1];
					arr1[j+1] = temp;
				}
			}
		}
	}
	
	public static int[] mergeSort(int arr[], int l, int r) {
		if(l==r) {
			return new int[] {arr[l]};
		}
		int mid = (l+r)/2;
		
		//left half
		int arr1[] = mergeSort(arr,l,mid);
		
		//right half
		int arr2[] = mergeSort(arr,mid+1,r);
		
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