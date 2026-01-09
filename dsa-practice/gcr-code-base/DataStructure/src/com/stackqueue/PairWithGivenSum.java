package com.stackqueue;

import java.util.HashMap;

public class PairWithGivenSum {
	public static void main(String args[]) {
		int arr[] = {15,20,7,8,11};
		int target = 15;
		System.out.println(isPair(arr,target));
	}
	public static boolean isPair(int arr[], int target) {
		HashMap<Integer,Integer> map = new HashMap<>();
		
		for(int i=0;i<arr.length;i++) {
			if(map.containsKey(target-arr[i])) {
				return true;
			}
			map.put(arr[i], i);
		}
		return false;
	}
}