package com.collections.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RotateElements {
	public static void main(String[] args) {
		List<Integer>lists=new ArrayList<>(Arrays.asList(10,20,30,40,50));
		int k=2;
		
		Collections.rotate(lists, -k);
		System.out.println(lists);
		
	}
}
