package com.collections.set;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UnionAndIntersection {
	public static void main(String[] args) {
		Set<Integer>set1=new HashSet<>(Arrays.asList(1,2,3));
		Set<Integer>set2=new HashSet<>(Arrays.asList(3,4,5));
		
		Set<Integer>union=new HashSet<>();
		union.addAll(set1);
		union.addAll(set2);
		System.out.println("Union: "+union);
		
		List<Integer>intersection=new ArrayList<>(set1);
		intersection.retainAll(set2);
		System.out.println("Intersection: "+intersection);
	}
}
