package com.timecomplexity;
import java.util.*;

public class DataStructureSearching {
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.println("Enter the size of array: ");
		int n = sc.nextInt();
		
		int arr[] = new int[n];
		HashMap<Integer,Integer> map = new HashMap<>();
		TreeSet<Integer> set = new TreeSet<>();
		
		for(int i=0;i<n;i++) {
			arr[i] = n-i;
			map.put(i, map.getOrDefault(i,0)+1);
			set.add(i);
		}
		
		//arraysearch
		long start_arraysearch_time = System.nanoTime();
		arraysearch(arr,1);
		long end_arraysearch_time = System.nanoTime();
		System.out.println("array linear serach time takne	: "+(end_arraysearch_time-start_arraysearch_time));
		
		//HashMapsearch
		long start_hashMapSearch_time = System.nanoTime();
		hashMapSearch(map,n-1);
		long end_hashMapSearch_time = System.nanoTime();
		System.out.println("HashMap Search time taken	: "+(end_hashMapSearch_time-start_hashMapSearch_time));
		
		//TreeSetsearch
		long start_treeSetSearch_time = System.nanoTime();
		treeSetSearch(set, n-1);
		long end_treeSetSearch_time = System.nanoTime();
		System.out.println("TreeSet search time taken	: "+(end_treeSetSearch_time-start_treeSetSearch_time));
		
	}
	
	public static void arraysearch(int arr[], int target) {
		for(int i=0;i<arr.length;i++) {
			if(arr[i]==target) {
				return;
			}
		}
	}
	
	public static void hashMapSearch(HashMap<Integer,Integer> map, int target) {
		for(var c :map.entrySet()) {
			if(c.getKey()==target) {
				return;
			}
		}
	}

	public static void treeSetSearch(TreeSet<Integer> set, int target) {
		for(int i=0;i<set.size();i++) {
			if(set.contains(target)) {
				return;
			}
		}
	}
}