package com.workshoponjava8features.smartcitytransport;

import java.util.List;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		Transport bus = new Bus("A-B", 30, 300);
		Transport metro = new MetroService("A-B", 30, 300);
		Transport tax = new TaxiService("A-B", 30, 300);
		List<Transport> list = List.of(
					bus,
					metro,
					tax
				);
		
		
		//
		System.out.println(
				list.stream()
						.sorted((a,b) -> a.getDepartureTime()-b.getDepartureTime())
						.findFirst()
				);
		System.out.println("\n\n");
		//live Show
		list.forEach(System.out::println);
		
		System.out.println("\n\n");
		System.out.println(
					list.stream()
		         		.collect(Collectors.groupingBy(Transport::getRoute))
				);
		
		System.out.println("\n\n");
		list.stream()
			.map(Transport::toString)
			.forEach(System.out::println);

	}

}
