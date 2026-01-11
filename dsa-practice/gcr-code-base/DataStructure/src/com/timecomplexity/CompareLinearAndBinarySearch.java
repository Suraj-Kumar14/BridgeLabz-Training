package com.timecomplexity;

public class CompareLinearAndBinarySearch {
	private static long linearSearch(int nums[], int target) {
		long startTime = System.nanoTime();
		for(int i=0; i<nums.length; i++) {
			if(nums[i] == target) break;
		}
		long endTime = System.nanoTime();
		return endTime - startTime;
	}
	private static long binarySearch(int[] nums, int target) {
		long startTime = System.nanoTime();
		int st = 0, end = nums.length - 1;
		 
		while(st <= end) {
			int mid = st + (end - st) / 2;
			
			if(nums[mid] == target) break;
			else if(nums[mid] < target) st = mid+1;
			else end = mid-1;
		}
		long endTime = System.nanoTime();
		return endTime - startTime;
	}
	public static void main(String[] args) {
		int nums[] = new int[1000000];
		int target = 999999;
		
		for(int i=0; i<nums.length; i++) {
			nums[i] = i+1;
		}
		
		long time1 = linearSearch(nums, target);
		// Arrays.sort(nums); -> Array is already sorted in ascending order
		long time2 = binarySearch(nums, target);
		
		System.out.println("Time taken by Linear Search: " + time1);
		System.out.println("Time taken by Binary Search: " + time2);
	}
}