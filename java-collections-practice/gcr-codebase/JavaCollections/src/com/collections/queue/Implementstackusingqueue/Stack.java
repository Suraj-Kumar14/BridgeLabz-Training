package com.collections.queue.Implementstackusingqueue;

import java.util.LinkedList;
import java.util.Queue;

public class Stack {
	
	Queue<Integer>q1=new LinkedList<>();
	Queue<Integer>q2=new LinkedList<>();
	
	public void push(Integer n) {
		while(!q1.isEmpty()) {
			q2.add(q1.poll());
		}
		q1.add(n);
		
		while(!q2.isEmpty()) {
			q1.add(q2.poll());
		}
	}
	
	public void pop() {
		while(q1.isEmpty()) {
			System.out.println("Stack is empty. can't perform pop operation");
			return;
		}
		System.out.println(q1.peek());
	}
	
	public void peek() {
		while(q1.isEmpty()) {
			System.out.println("Stack is empty, can't perform peek operation.");
			return;
		}
		System.out.println(q1.peek());
	}
	
	public void show() {
		System.out.println("-----Stack Elements-----");
		if(!q1.isEmpty()) {
				System.out.println(q1.toString());
			
		}else {
			System.out.println("Stack is empty!");
		}
		System.out.println();	
	}
}
