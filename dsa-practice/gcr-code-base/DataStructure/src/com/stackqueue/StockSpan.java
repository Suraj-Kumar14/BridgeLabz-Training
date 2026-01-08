package com.stackqueue;

import java.util.ArrayList;
import java.util.Stack;

public class StockSpan {

	public static void main(String[] args) {
		int[] arr = {10, 4, 5, 90, 120, 80};
		
		ArrayList<Integer> list = new ArrayList<>();
		
		Stack<Integer> stack = new Stack<>();
		
		for(int i=0;i<arr.length;i++) {
			while(!stack.isEmpty() && arr[stack.peek()]<=arr[i]) {
				stack.pop();
			}
			
			if(stack.isEmpty()) {
				list.add(i+1);
			}
			else {
				list.add(i-stack.peek());
			}
			stack.push(i);
		}
		
		//print the span
		for(int k=0;k<list.size();k++) {
			System.out.print(list.get(k)+" ");
		}
	}
}
