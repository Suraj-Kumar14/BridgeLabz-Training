package com.collections.Map;

import java.util.HashMap;
import java.util.Map;

public class MaxValue {

	public static void main(String[] args) {
		
		Map<String,Integer>hm=new HashMap<>();
		
		hm.put("A", 10);
		hm.put("B", 20);
		hm.put("C", 15);
		
		String str="";
		int max=Integer.MIN_VALUE;
		for(Map.Entry<String, Integer> i:hm.entrySet()) {
			if(i.getValue()>max) {
				max=i.getValue();
				str=i.getKey();
			}
		}
		System.out.println(str);
	}

}
