package com.scenarioquestion;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.scenarioquestion.employee.Employee;

public class ListMapConversion {
	
	public static void main(String[] args) {
		
		//1.Convert List of strings to Map with string as key and length as value
		List<String>list=Arrays.asList("Hello","Mohan","Morning","Good");
		Map<String,Integer>map=list.stream().collect(Collectors.toMap(str->str, str->str.length()));
		System.out.println(map);
		
		//2.Convert List of integers to Map with number and its square
		List<Integer>number=Arrays.asList(1,2,3,4,5);
		Map<Integer,Integer>square=number.stream().collect(Collectors.toMap(n->n,n->n*n));
		System.out.println(square);
		
		//3.Convert List of employees to Map with id as key and name as value
		List<Employee>employees=Arrays.asList(new Employee(1,"Sohan"),new Employee(3,"Monu"),new Employee(2,"Sonu"));
		Map<Integer,String>employee=employees.stream().collect(Collectors.toMap(e->e.getId(), e->e.getName()));
		System.out.println(employee);
		
		//4.Convert List of words to Map with word and frequency
		List<String>words=Arrays.asList("java", "api", "java", "micro", "api");
		Map<String,Long>wordFreq=words.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		System.out.println(wordFreq);
	
		//5.Convert List to Map with index as key and element as value
		List<Integer>numbers=Arrays.asList(1,2,3,4,5);
		Map<Integer,Integer>indexValue=IntStream.range(0, numbers.size()).boxed().collect(Collectors.toMap(i->i,numbers::get));
		System.out.println(indexValue);
		
		//6.Convert List of objects to Map using custom key field
		List<Employee>emp=Arrays.asList(new Employee(1,"Sonu"),new Employee(2,"Sohan"),new Employee(3,"Suraj"));
		Map<Integer,Employee>mp=emp.stream().collect(Collectors.toMap(Employee::getId,Function.identity()));
		System.out.println(mp);
		
		//7.Convert List to Map and handle duplicate keys
		List<String> lst = Arrays.asList("java", "api", "java", "micro");
		Map<String,Integer>handleDuplicate=lst.stream().collect(Collectors.toMap(Function.identity(), String::length,(oldValue,newValue)->newValue));
		System.out.println(handleDuplicate);
	
		//8.Convert List to Map keeping only first duplicate
		List<String> lists = Arrays.asList("java", "api", "java", "micro", "api");
		Map<String,Integer>firstDuplicate=lists.stream().collect(Collectors.toMap(Function.identity(),String::length,(oldValue,newValue)->oldValue));
		System.out.println(firstDuplicate);
		
		//9.Convert List to Map keeping only last duplicate
		List<String> list1 = Arrays.asList("java", "api", "java", "micro", "api");
		Map<String,Integer>lastDuplicate=list1.stream().collect(Collectors.toMap(Function.identity(), String::length,(oldValue,newValue)->newValue));
		System.out.println(lastDuplicate);
		
		//10.Convert List into Map grouped by string length
		List<String> elements = Arrays.asList("java", "api", "java", "micro", "api");
		Map<Integer,List<String>>group=elements.stream().collect(Collectors.groupingBy(String::length));
		System.out.println(group);
	
	
	
	
	}
}
