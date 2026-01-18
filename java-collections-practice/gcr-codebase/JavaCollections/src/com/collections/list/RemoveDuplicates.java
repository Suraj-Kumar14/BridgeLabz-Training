package com.collections.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RemoveDuplicates {
	
	public static void main(String[] args) {
		List<Integer>lists=new ArrayList<>(Arrays.asList(3,1,2,2,3,4));
		List<Integer>result=new ArrayList<>();
		System.out.println("Before removing element.");
		System.out.println(lists);
		
		System.out.println("After remove duplicate.");
		for (Integer num:lists) {
			if(!result.contains(num)) {
				result.add(num);
			}
		}
		System.out.println(result);
	}
}
