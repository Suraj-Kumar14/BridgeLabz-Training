package com.scenarioquestion;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.scenarioquestion.comparatorquestion.Employee;

public class LogicalQuestion {
	
	public static void main(String[] args) {
		
		/*1.1. Count vowels in a string using Stream
		       Input: "programming"
			   Output: 3
		*/
//		
		String input="programming";
		long count=input.toLowerCase().chars().mapToObj(c->(char)c).filter(c->"aeiou".indexOf(c)!=-1).count();
//		input.toLowerCase().chars().mapToObj(c->(char)c).collect(Collectors.groupingBy(c->"aeiou".indexOf(c)!=-1 ? "Vowels" : "Consonants",Collectors.counting())).forEach((k,v)->System.out.println(k+": "+v));
		System.out.println("Number of vowels: "+count);
		
		
		/*	2.Count number of words in a sentence
			  Input: "Java is very powerful"
		   	  Output: 4
		 */
		
		String input1="Java is very powerful";
//		long wordCount=Arrays.stream(input1.split("\\s+")).count();
		long wordCount=input1.split("\\s+").length;
		System.out.println("Total word: "+wordCount);

//		long count1=Stream.of(input1.split("\\s+")).count();
//		System.out.println("Total word: "+count1);
				
		
		/*3. Find even numbers from list
			 Input: [2,5,7,8,10,13]
			 Output: [2,8,10]  
		 */
		
		List<Integer>list=Arrays.asList(2,3,7,8,10,13);
		List<Integer>result=list.stream().filter(n->n%2==0).toList();
		System.out.println(result);
		
		/*4. Convert list of strings to uppercase
			 Input: ["java","spring","boot"]
			 Output: ["JAVA","SPRING","BOOT"]		  
		 */
		
		List<String>string=Arrays.asList("java","spring","boot");
		List<String>result1=string.stream().map(String::toUpperCase).toList();
		System.out.println(result1);
		
		/*5. Find string length list
			 Input: ["cat","elephant","dog"]
			 Output: [3,8,3]						 
		 */
		
		List<String>input2=Arrays.asList("cat","elephant","dog");
		List<Integer>output=input2.stream().map(String::length).toList();
		System.out.println(output);
		
		/*6. Count strings starting with ‘a’
			Input: ["apple","banana","ant","car"]
			Output: 2		 
		 */
		
		List<String>str=Arrays.asList("apple","banana","ant","car");
		long countStr=str.stream().filter(c->c.startsWith("a")).count();
		System.out.println(countStr);
		
		/*7. Remove empty strings
			Input: ["java","","spring","","boot"]
			Output: ["java","spring","boot"]		  
		 */
		
		List<String>listStr=Arrays.asList("java","","spring","","boot");
		List<String>strOutput=listStr.stream().filter(c->!c.equals("")).toList();
		System.out.println(strOutput);
		
		/*8. Sum of all numbers using stream
			Input: [1,2,3,4,5]
			Output: 15		 
		 */
		
		List<Integer>number=Arrays.asList(1,2,3,4,5);
		int sum=number.stream().mapToInt(Integer::intValue).sum();
		System.out.println("Sum of number: "+sum);
		
		/*9. Find max number
			Input: [10,25,3,99,45]
			Output: 99
		 */
		
		List<Integer>num=Arrays.asList(10,25,3,99,45);
		int max=num.stream().mapToInt(Integer::intValue).max().orElse(0);
		System.out.println("Max value: "+max);
		
		/*10. Reverse each string in list
			Input: ["java","api"]
			Output: ["avaj","ipa"] 
		 */
		
		List<String>str1=Arrays.asList("java","api");
		List<String>rev=str1.stream().map(s->new StringBuilder(s).reverse().toString()).toList();
		System.out.println("Reverse String= "+rev);
		
		/*11. Remove duplicate elements from list
				Input: [1,2,2,3,4,4,5]
				Output: [1,2,3,4,5]		  
		 */
	
		List<Integer>number1=Arrays.asList(1,2,2,3,4,4,5);
		List<Integer>duplicate=number1.stream().distinct().toList();
		System.out.println(duplicate);
		
		/*12. Sort list in descending order
			Input: [5,1,9,3]
			Output: [9,5,3,1]
		 */
	
		List<Integer>list1=Arrays.asList(5,1,9,3);
		List<Integer>desc=list1.stream().sorted().toList().reversed();
		System.out.println(desc);
	
		/*	13. Find second highest number
				Input: [10,40,30,20]
				Output: 30	  
		 */
		
		List<Integer>list2=Arrays.asList(10,40,30,20);
//		list2.stream().sorted().toList().reversed().stream().skip(1).findFirst().ifPresent(System.out::println);
		list2.stream().sorted(Comparator.comparing(s->s,Comparator.reverseOrder())).skip(1).findFirst()
		.ifPresent(System.out::println);
		
	
		/*14. Join strings with comma
			  Input: ["Java","Spring","Boot"]
			  Output: "Java,Spring,Boot"
	     */
	
		List<String>str2=Arrays.asList("Java","Spring","Boot");
		String join=str2.stream().collect(Collectors.joining(",")).toString();
		System.out.println(join);
		
		/*15. Frequency of each character
			  Input: "banana"
			  Output: {b=1, a=3, n=2}
		*/
		
		String s="banana";
		Map<Character,Long>freq=s.chars().mapToObj(c->(char)c).collect(Collectors.groupingBy(c->c, Collectors.counting()));	
		System.out.println(freq);
		
		
		/*16. Find numbers greater than 50
			  Input: [10,55,60,23,90]
			  Output: [55,60,90]
		 */
		
		List<Integer>numbers=Arrays.asList(10,55,60,23,90);
		List<Integer>greater=numbers.stream().filter(n->n>50).toList();
		System.out.println(greater);
		
		/*17. Group strings by length
			  Input: ["a","bb","ccc","dd"]
			  Output: {1=[a], 2=[bb,dd], 3=[ccc]}
		 */
		
		List<String>strs=Arrays.asList("a","bb","ccc","dd");
		Map<Integer, List<String>>length=strs.stream().collect(Collectors.groupingBy(String::length));
		System.out.println(length);
		
		/*18. Find first non-repeated character
			  Input: "stress"
			  Output: t		
		 */
		
		String ip="stress";
		Map<Character,Long>np=ip.chars().mapToObj(c->(char)c).collect(Collectors.groupingBy(c->c,Collectors.counting()));
		ip.chars().mapToObj(c->(char)c).filter(c->np.get(c)==1).findFirst().ifPresent(System.out::println);
//		ip.chars().mapToObj(c->(char)c).collect(Collectors.groupingBy(c->c,LinkedHashMap::new ,Collectors.counting())).entrySet().stream().filter(c->c.getValue()==1).findFirst().ifPresent(System.out::println);
		
		/*19. Convert List<Integer> to List<String>
			  Input: [1,2,3]
			  Output: ["1","2","3"]		  
		 */
		
		List<Integer>lst=Arrays.asList(1,2,3);
		List<String>strList=lst.stream().map(ch->ch.toString()).toList();
		System.out.print("[ ");
		strList.stream().forEach(ch->System.out.print("\""+ch+"\""+" "));
		System.out.println(" ]");
		
		
		/*20. Count occurrences of each word
			  Input: "java is java and java is fast"
			  Output: {java=3, is=2, and=1, fast=1}
		 */
		
		String occur="java is java and java is fast";
//		Map<String,Long>occurences=Stream.of(occur.split("\\s+")).collect(Collectors.groupingBy(c->c,Collectors.counting()));
//		System.out.println(occurences);
		
		Map<String,Long>occurence=Arrays.stream(occur.split("\\s+")).collect(Collectors.groupingBy(c->c,Collectors.counting()));
		System.out.println(occurence);
		
		
		/*	21. Partition numbers into even and odd
				Input: [1,2,3,4,5,6]
				Output: {even=[2,4,6], odd=[1,3,5]}	 
		 */
		
		List<Integer>no=Arrays.asList(1,2,3,4,5,6);
		List<Integer>even=no.stream().filter(n->n%2==0).toList();
		List<Integer>odd=no.stream().filter(n->n%2!=0).toList();
		System.out.println("{"+"even="+even+", odd="+odd+"}");
		
		/* 22. Find duplicate elements only
				Input: [1,2,3,2,4,5,1]
				Output: [1,2]
		 */
		
		List<Integer>elements=Arrays.asList(1,2,3,2,4,5,1);
//		List<Integer>duplicates=elements.stream().collect(Collectors.groupingBy(n->n,Collectors.counting())).entrySet().stream().filter(n->n.getValue()>1).map(Map.Entry::getKey).toList();
//		System.out.println("Duplicates no: "+duplicates);
		Set<Integer>seen=new HashSet<>();
		List<Integer>duplicates=elements.stream().filter(n->!seen.add(n)).toList();
		System.out.println(duplicates);
		
		/*	23. Find longest string
				Input: ["java","microservices","api"]
				Output: "microservices"	 
		 */
		
		List<String>strInput=Arrays.asList("java","microservices","api");
		String longest=strInput.stream().sorted(Comparator.comparing(String::length).reversed()).findFirst().get();
		System.out.println(longest);
		
		
		/*	24. Find top 3 highest numbers
				Input: [10,90,30,70,50]
				Output: [90,70,50]	 
		 */
		
		List<Integer>numbers1=Arrays.asList(10,90,30,70,50);
		List<Integer>highest3=numbers1.stream().sorted(Comparator.comparing(n->n,Comparator.reverseOrder())).limit(3).toList();
		System.out.println(highest3);
		
		
		/*25. Flatten list of lists
			  Input: [[1,2],[3,4],[5]]
			  Output: [1,2,3,4,5]		 
		 */
		
		List<List<Integer>>lt=Arrays.asList(Arrays.asList(1,2),Arrays.asList(3,4),Arrays.asList(5));
//		List<Integer>flatten=lt.stream().flatMap(innerList->innerList.stream()).toList();
		List<Integer>flatten=lt.stream().flatMap(List::stream).toList();
		System.out.println(flatten);
		
		
		/*26. Find sum of squares of even numbers
			  Input: [1,2,3,4,5]
			  Output: 20 (2² + 4²)
		 */
		
		List<Integer>numb=Arrays.asList(1,2,3,4,5);
		int sum1=numb.stream().filter(n->n%2==0).mapToInt(n->n*n).sum();
		System.out.println(sum1);
		
		/*27. Sort map by value
			  Input: {A=3, B=1, C=2}
			  Output: {B=1, C=2, A=3}
		 */
		
		Map<Character,Integer>mp=new HashMap<>();
		mp.put('A',3);
		mp.put('B',1);
		mp.put('C',2);
		
		Map<Character,Integer>sorted=mp.entrySet().stream().sorted(Map.Entry.comparingByValue())
													.collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue,(k,v)->k,LinkedHashMap::new));
		System.out.println(sorted);
		
		/*28. Find employee with highest salary (using stream)
			  Input: List of Employees
			  Output: Employee object with max salary
		 */
		
		List<Employee>employees=Arrays.asList( new Employee("Rahul", 50000),
                new Employee("Anita", 75000),
                new Employee("Vikram", 60000));
		
		double highest=employees.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).findFirst().get().getSalary();
		System.out.println(highest);
		
		/*	29. Find common elements between two lists
				Input: [1,2,3,4] and [3,4,5,6]
				Output: [3,4]	
		 */
		
		List<Integer>lst1=Arrays.asList(1,2,3,4);
		List<Integer>lst2=Arrays.asList(3,4,5,6);
		
		List<Integer>common=lst1.stream().filter(lst2::contains).toList();
		System.out.println(common);
		
		/*	30. Find kth smallest element
				Input: [9,1,5,3,7], k=2
				Output: 3	
		 */
		
		List<Integer>element=Arrays.asList(9,1,5,3,7);
		int smallest=element.stream().sorted().skip(1).findFirst().get();
		System.out.println(smallest);
	}
}
