package com.searchingalgorithms.binarysearch;

public class FirstNegativeSearch {
	
	public static int findFirstNegative(int[] arr) {
		for(int i=0;i<arr.length;i++) {
			if(arr[i]<0) {
				return i;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		int[] numbers= {5,12,7,-3,9,-1};
		
		int index=findFirstNegative(numbers);
		
		if(index!=-1) {
			System.out.println("First negative number found at index: "+index);
		}else {
			System.out.println("No negative number found in the array.");
		}
	}
}
