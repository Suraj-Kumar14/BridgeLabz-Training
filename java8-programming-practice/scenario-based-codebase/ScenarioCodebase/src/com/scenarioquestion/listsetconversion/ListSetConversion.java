package com.scenarioquestion.listsetconversion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.scenarioquestion.employee.Employee;


public class ListSetConversion {

	public static void main(String[] args) {
		
		//1.Convert List to Set (remove duplicates)
		List<String> listStr = Arrays.asList("java", "api", "java", "micro", "api");
		Set<String>set1=new HashSet<>(listStr);
		System.out.println(set1);
		
			List<Integer>list=Arrays.asList(6,2,1,4,3,2,5,1);
//			Set<Integer>set=new HashSet<>(list);
//			System.out.println(set);
		
		//2.Convert List to LinkedHashSet (preserve order)
		Set<String>lh=new LinkedHashSet<>(listStr);
		System.out.println(lh);
		
		//3.Convert List to TreeSet (sorted)
		Set<String>ts=new TreeSet<>(listStr);
		System.out.println(ts);
		
		//4.Convert Set to List
		List<String>str=new ArrayList<>(set1);
//				set1.stream().toList();
		System.out.println(str);
		
		//5.Convert Set to Sorted List
		List<String>sort=set1.stream().sorted().toList();
		System.out.println(sort);
	
		//6.Convert Set of objects to List of names
		Set<Employee>emp=new HashSet<>();
		emp.add(new Employee(1,"Mohit"));
		emp.add(new Employee(3,"Allu"));
		emp.add(new Employee(2,"Kali"));
		
		List<String>name=emp.stream().map(Employee::getName).toList();
		System.out.println(name);
		
		//7.Convert List to Set after filtering condition
		Set<Integer>filterSet=list.stream().filter(n->n>3).collect(Collectors.toSet());
		System.out.println(filterSet);
		
		//8.8.Convert List to Set of squares
		Set<Integer>square=list.stream().map(n->n*n).collect(Collectors.toSet());
		System.out.println(square);
		
		//9.Convert Set to List and reverse order
		List<Integer>reverse=square.stream().toList().reversed();
		System.out.println(reverse);
		
		//10.Merge two Lists and convert to Set
		List<Integer>list1=Arrays.asList(2,3,1,5,4);
		List<Integer>list2=Arrays.asList(6,4,7,3);
		
		Set<Integer>mergedSet=Stream.concat(list1.stream(),list2.stream()).collect(Collectors.toSet());
		System.out.println(mergedSet);
	}

}
