package com.collections.list.reverselist;

import java.util.ArrayList;
import java.util.List;

public class ReverseUsingArrayList {
	
	public static void reverseArrayList(List<Integer>list) {
		int left=0;
		int right=list.size()-1;
		
		while(left<right) {
			int temp=list.get(left);
			list.set(left,list.get(right));
			list.set(right,temp);
			left++;
			right--;
		}
	}
	
	public static void main(String[] args) {
		List<Integer>number=new ArrayList<>();
		number.add(1);
		number.add(2);
		number.add(3);
		number.add(4);
		number.add(5);
		
		System.out.println("Original number: "+number);
		reverseArrayList(number);
		System.out.println("Reversed ArrayList: "+number);
	}
}
