package com.collections.list.frequencyofelements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindFrequency {
	public static Map<String,Integer>findFrequency(List<String>lists){
		Map<String,Integer>frequencyMap=new HashMap<>();
		for(String list:lists) {
			frequencyMap.put(list, frequencyMap.getOrDefault(list,0)+1);
		}
		return frequencyMap;
	}
	
	public static void main(String[] args) {
		List<String>lists=new ArrayList<>();
		lists.add("apple");
		lists.add("banana");
		lists.add("apple");
		lists.add("orange");
		
		Map<String,Integer>result=findFrequency(lists);
		System.out.println(result);		
	}
}
