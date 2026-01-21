package com.collections.Map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InvertMap {
	public static <K,V> Map<V,List<K>>invertMap(Map<K,V>input){
		Map<V, List<K>>result=new HashMap<>();
		
		for(Map.Entry<K, V>entry: input.entrySet()) {
			K Key=entry.getKey();
			V Value=entry.getValue();
			
			result.computeIfAbsent(Value, v -> new ArrayList<>())
			.add(Key);
		}
		return result;
	}
	
	public static void main(String[] args) {
		Map<String,Integer>map=new HashMap<>();
		map.put("A",1);
		map.put("B",2);
		map.put("C",1);
		
		System.out.println(invertMap(map));
	}

}
