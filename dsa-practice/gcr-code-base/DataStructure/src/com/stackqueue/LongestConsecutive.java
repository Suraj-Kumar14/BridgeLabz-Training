package com.stackqueue;

import java.util.Arrays;

public class LongestConsecutive {
	public static void main(String args[]) {
		 int[] arr = { 2, 2, 3, 1, 4, 5, 6 };
	     System.out.println("Longest Consecutive is: "+find(arr));
	}
	public static int find(int arr[]) {
		int cnt = 1;
		int result = 1;
		
		//here we sort the array
		Arrays.sort(arr);
		
		if(arr.length==0) {
			return 0;
		}
		for(int i=1;i<arr.length;i++) {
			if(arr[i]==arr[i-1]) {
				continue;
			}
			if(arr[i]==arr[i-1]+1) {
				cnt+=1;
			}
			else {
				cnt = 1;
			}
			
			result = Math.max(cnt, result);
		}
		return result;
	}
}