package com.streamAPI.IoTsensorreading;

import java.util.List;

public class Main {

	public static void main(String[] args) {
		
		List<Integer>reading=List.of(30,45,74,54,62,32,40);
		int threshold=40;
		
		reading.stream().filter(x->x>40).forEach(System.out::println);

	}

}
