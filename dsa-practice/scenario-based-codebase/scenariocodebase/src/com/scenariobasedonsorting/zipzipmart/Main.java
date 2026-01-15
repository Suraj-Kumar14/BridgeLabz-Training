package com.scenariobasedonsorting.zipzipmart;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
	
	public static void main(String[] args) {
		ZipZipMart mart=new ZipZipMart();
		
        List<Sale> sales = new ArrayList<>();
        sales.add(new Sale(LocalDate.of(2026, 1, 15), 500));
        sales.add(new Sale(LocalDate.of(2026, 1, 14), 200));
        sales.add(new Sale(LocalDate.of(2026, 1, 15), 200));
        sales.add(new Sale(LocalDate.of(2026, 1, 14), 200));

        System.out.println("Before Sorting:");
        for (Sale s : sales) System.out.println(s);

        List<Sale> sortedSales =mart.mergeSort(sales);

        System.out.println("\nAfter Sorting:");
        for (Sale s : sortedSales) System.out.println(s);
    }

}