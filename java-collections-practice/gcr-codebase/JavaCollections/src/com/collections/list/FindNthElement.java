package com.collections.list;

import java.util.Arrays;
import java.util.LinkedList;

public class FindNthElement {

	public static void main(String[] args) {
		LinkedList<Character>node=new LinkedList<>(Arrays.asList('A','B','C','D','E'));
	    int i =2;
	    while(i>1) {
	    	node.pollLast();
	    	i--;
	    }
	    System.out.println(node.pollLast());
	    
	}

}
