package com.stackqueue;

public class SubarrayswithZeroSum {

	public static void main(String[] args) {
		int arr[] = {6, 3, -1, -3, 4, -2, 2, 4, 6, -12, -7};
		
		for(int i=0;i<arr.length;i++) {
			int sum = 0;
			for(int j=i;j<arr.length;j++) {
				sum+=arr[j];
				if(sum==0) {
					System.out.println("Subarray with zero sum index is: "+i+" to "+j);
				}
			}
		}
	}
}