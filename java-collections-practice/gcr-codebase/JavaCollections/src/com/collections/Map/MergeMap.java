package com.collections.Map;

import java.util.HashMap;
import java.util.Map;

public class MergeMap {

	public static void main(String[] args) {
		
		Map<String,Integer>Map1=new HashMap<>();
		Map<String,Integer>Map2=new HashMap<>();
		
		Map1.put("A",1);
		Map1.put("B",5);
		Map2.put("C",4);
		Map2.put("A",3);
		
		Map<String,Integer>result=new HashMap<>();
		
		for(Map.Entry<String,Integer> entry:Map1.entrySet()) {
			result.put(entry.getKey(), entry.getValue());
		}
		
		for(Map.Entry<String, Integer>entry:Map2.entrySet()) {
			result.put(entry.getKey(), result.getOrDefault(entry.getKey(), 0)+entry.getValue());
			
		}
		System.out.println(result);
		
	}

}
