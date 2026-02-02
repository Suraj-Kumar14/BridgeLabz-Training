package com.collectors.librarybooksstatistics;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		
		List<Book>books=new ArrayList<>();
		
		books.add(new Book("Fiction", 567));
		books.add(new Book("Horror", 434));
		books.add(new Book("Comedy", 289));
		books.add(new Book("Romance", 320));
		books.add(new Book("Science", 610));

		long totalPages=books.stream().collect(Collectors.summingLong(Book::getPages));
		System.out.println("Total pages: "+totalPages);
		double averagePage=books.stream().collect(Collectors.averagingDouble(Book::getPages));
		System.out.println("Average pages: "+averagePage);
		System.out.println(
					books.stream().sorted(Comparator.comparing(Book::getPages).reversed()).findFirst().get()
				);
		
//		Optional<Book>maximumPageGenre= books.stream()
//											.sorted(Comparator.comparing(Book::getPages).reversed()).findFirst();
//		
//		System.out.println(maximumPageGenre.get());
												
	}									
}
