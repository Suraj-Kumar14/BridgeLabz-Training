package com.collections.queue;

import java.util.LinkedList;
import java.util.Queue;

public class CircularBufferSimulation {
	static Queue<Integer>queue=new LinkedList<>();
	private static final int CAPACITY=3;
	public void addElement(Integer n) {
		if(queue.size()==CAPACITY) {			
			queue.poll();
		}
			queue.add(n);
	}
	
	public void show() {
		if(queue.isEmpty()) {
			System.out.println("Empty Queue.");
			return;
		}
		System.out.println(queue.toString());		
	}
	
	public static void main(String[] args) {
		
		CircularBufferSimulation buffer=new CircularBufferSimulation();
		buffer.addElement(1);
		buffer.addElement(2);
		buffer.addElement(3);
		
		buffer.show();
		buffer.addElement(4);
		
		buffer.show();
		buffer.addElement(5);
		buffer.show();
		
	}
}
