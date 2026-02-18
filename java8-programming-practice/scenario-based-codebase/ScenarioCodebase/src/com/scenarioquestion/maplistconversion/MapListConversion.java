package com.scenarioquestion.maplistconversion;

import java.util.*;
import java.util.stream.Collectors;

public class MapListConversion {

	public static void main(String[] args) {
		
		//1.Convert Map keys to List
		Map<String, Integer> map = new HashMap<>();
		map.put("java", 4);
		map.put("api", 3);
		map.put("micro", 5);
		
		List<String>keys=new ArrayList<>(map.keySet());
//		List<String>keys=map.keySet().stream().toList();	
		System.out.println(keys);
		
		//2.Convert Map values to List
		List<Integer>values=new ArrayList<>(map.values());
//		List<Integer>values=map.values().stream().toLIst();
		System.out.println(values);
		
		//3.Convert Map entries to List
		List<Map.Entry<String, Integer>>entries=new ArrayList<>(map.entrySet());
//		List<Map.Entry<String,Integer>>entries=map.entrySet().stream().toList();
		System.out.println(entries);
		
		//4.Convert Map to List of key-value strings
		List<String>keyValueString=map.entrySet().stream().map(e->e.getKey()+"="+e.getValue()).collect(Collectors.toList());
		System.out.println(keyValueString);
		
		//5.Convert Map to List of custom objects
		List<Language>obj=map.entrySet().stream()
										.map(e->new Language(e.getKey(),e.getValue())).toList();
		System.out.println(obj);
		
		//6.Convert Map to sorted List by key
		List<String>sort=map.keySet().stream().sorted().toList();
		System.out.println(sort);
		
		//7.Convert Map to sorted List by value
		List<Integer>sortValue=map.values().stream().sorted().toList();
		System.out.println(sortValue);
		
		//8.Convert Map to List and filter by value > N
		List<String>filterByValue=map.entrySet().stream().filter(e->e.getValue()>3).map(e->e.getKey()+"="+e.getValue()).toList();
		System.out.println(filterByValue);
		
		//9.Convert Map to List of keys where value is even
		List<String>evenValues=map.entrySet().stream().filter(e->e.getValue()%2==0).map(e->e.getKey()+"="+e.getValue()).toList();
		System.out.println(evenValues);
		
		//10.Convert Map entries to List of DTO objects
		List<LanguageDTO>dtoList=map.entrySet().stream().map(l->new LanguageDTO(l.getKey(),l.getValue())).toList();
		System.out.println(dtoList);
	}

}
