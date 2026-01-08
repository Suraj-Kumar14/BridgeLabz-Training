package com.stackqueue;
import java.util.HashMap;

public class TwoSumProblem {

	public static void main(String[] args) {
		int arr[] = {15,20,7,8,11};
		int target = 15;
		
		HashMap<Integer,Integer> map = new HashMap<>();
		for(int i=0;i<arr.length;i++) {
			if(map.containsKey(target-arr[i])) {
				System.out.println("Two Sum index is: "+(map.get(target-arr[i])) + " & "+ (i));
				break;
			}
			map.put(arr[i], i);
		}
	}
}