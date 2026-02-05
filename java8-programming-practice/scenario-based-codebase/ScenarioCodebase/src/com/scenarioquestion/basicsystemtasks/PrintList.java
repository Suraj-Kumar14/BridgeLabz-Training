package com.scenarioquestion.basicsystemtasks;

import java.util.Arrays;
import java.util.List;

//2.Use lambda to print numbers from a list.

public class PrintList {

	public static void main(String[] args) {
		List<Integer>list=Arrays.asList(12,4,7,1,6,4);

		list.stream().forEach(n->System.out.print(n+" "));
	}

}
