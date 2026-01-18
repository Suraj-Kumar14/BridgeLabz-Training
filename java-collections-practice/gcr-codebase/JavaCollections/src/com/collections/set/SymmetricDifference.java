package com.collections.set;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SymmetricDifference {

	public static void main(String[] args) {
		Set<Integer>set1=new HashSet<>(Arrays.asList(1,2,3));
		Set<Integer>set2=new HashSet<>(Arrays.asList(3,4,5));
		
		Set<Integer>symmetric=new HashSet<>(set1);
		symmetric.addAll(set2);
		
		List<Integer>intersection=new ArrayList<>(set1);
		intersection.retainAll(set2);
		
		symmetric.removeAll(intersection);
		System.out.println("Symmetric difference: "+symmetric);
	}
}
