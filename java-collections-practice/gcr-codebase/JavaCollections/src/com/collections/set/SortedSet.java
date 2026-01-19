package com.collections.set;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class SortedSet {
	public static void main(String[] args) {
		Set<Integer>set=new HashSet<>();
		
		set.add(5);
		set.add(3);
		set.add(9);
		set.add(1);
		
		TreeSet<Integer>ts=new TreeSet<>(set);
		
//		for(Integer s:set) {
//			ts.add(s);
//		}
		System.out.println(ts);
	}
}
