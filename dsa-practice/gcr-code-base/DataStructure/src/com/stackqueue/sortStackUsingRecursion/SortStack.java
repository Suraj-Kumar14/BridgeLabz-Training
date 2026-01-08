package com.stackqueue.sortStackUsingRecursion;

import java.util.Scanner;
import java.util.Stack;

public class SortStack {
	public static void main(String [] args) {
		Scanner sc=new Scanner(System.in);
		
		Stack<Integer>number=new Stack<>();
		
		System.out.println("Enter the size of stack: ");
		int n=sc.nextInt();
		
		while(n>0) {
			System.out.println("Enter the "+n+" number: ");
			number.push(sc.nextInt());
			n--;
		}
		
		Stack<Integer> sorted =new Stack<>();
		
		while(!number.isEmpty()) {
			int temp=number.pop();
			while(!sorted.isEmpty() && sorted.peek()>temp) {
				number.push(sorted.pop());
			}
			sorted.push(temp);
		}
		
		//display
		while(!sorted.isEmpty()) {
			System.out.println(sorted.pop()+" ");
		}
		sc.close();
	}
}
