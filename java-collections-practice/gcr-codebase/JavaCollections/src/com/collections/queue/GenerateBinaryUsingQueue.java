package com.collections.queue;

import java.util.LinkedList;
import java.util.Queue;

public class GenerateBinaryUsingQueue {

	public static void main(String[] args) {
		Queue<String>queue=new LinkedList<>();
		int n=5;
		int i=1;
		while(i<=n) {
			queue.add(Integer.toBinaryString(i));
			i++;
		}
		System.out.println(queue);
	}

}
