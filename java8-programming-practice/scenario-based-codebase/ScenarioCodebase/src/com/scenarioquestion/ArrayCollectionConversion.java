package com.scenarioquestion;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ArrayCollectionConversion {

	public static void main(String[] args) {
		
		//1.Convert array to List using stream
		int[] arr= {6,8,3,5,1,4};
		List<Integer>number=Arrays.stream(arr).boxed().toList();
		System.out.println(number);
		
		//2.Convert array to Set
		 Set<Integer>set=Arrays.stream(arr).boxed().collect(Collectors.toSet());
		 System.out.println(set);
		 
		 //3.Convert List to array
		 int[] array=number.stream().mapToInt(Integer::intValue).toArray();
		 System.out.println(Arrays.toString(array));
		 
		 //4.Convert Set to array
		 int[] ar=set.stream().mapToInt(Integer::intValue).toArray();
		 System.out.println(set);
	}

}
