package com.searchingalgorithms;

import java.util.HashSet;
import java.util.Scanner;

public class RemoveDuplicatesUsingStringBuilder {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter String: ");
		String name=sc.nextLine();
		
		System.out.println("Before: "+name);
		System.out.println("Afetr remove duplicate: "+duplicateSolve(name));
	}
	
	public static String duplicateSolve(String str) {
		
		HashSet<Character>set=new HashSet<>();
		StringBuilder st=new StringBuilder();
		
		for(int i=0;i<str.length();i++) {
			char c=str.charAt(i);
			if(!set.contains(c)) {
				st.append(c);
				set.add(c);
			}
		}
		return st.toString();
	}

}
