package com.scenariobasedonsorting.zipzipmart;

import java.util.ArrayList;
import java.util.List;

public class ZipZipMart {
		
	public static List<Sale> mergeSort(List<Sale>sale){
		if(sale.size()<=1) {
			return sale;
		}
		
		int mid=sale.size()/2;
		
		List<Sale>left=mergeSort(new ArrayList<>(sale.subList(0, mid)));
		List<Sale>right=mergeSort(new ArrayList<>(sale.subList(mid,sale.size())));
		
		return merge(left,right);
	}
	
		
	private static List<Sale> merge(List<Sale> left, List<Sale> right) {
        List<Sale> result = new ArrayList<>();
        int i = 0, j = 0;

        while (i < left.size() && j < right.size()) {
            if (compare(left.get(i), right.get(j)) <= 0) {
                result.add(left.get(i++));
            } else {
                result.add(right.get(j++));
            }
        }

        // add remaining elements
        while (i < left.size()) result.add(left.get(i++));
        while (j < right.size()) result.add(right.get(j++));

        return result;
	}
	
    // Compare by date first, then amount
    private static int compare(Sale s1, Sale s2) {
        int dateCompare = s1.getDate().compareTo(s2.getDate());
        if (dateCompare != 0) return dateCompare;
        return Double.compare(s1.getAmount(), s2.getAmount());
    }



}
