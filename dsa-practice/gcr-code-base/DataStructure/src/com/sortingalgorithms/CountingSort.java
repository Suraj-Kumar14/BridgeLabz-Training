package com.sortingalgorithms;

public class CountingSort {
	  public static void main(String[] args) {
	        int[] arr = {4, 2, 2, 8, 3, 3, 1};

	        countingSort(arr);

	        for (int n : arr) {
	            System.out.print(n + " ");
	        }
	    }
	 public static void countingSort(int[] arr) {
	        int max = arr[0];
	        for (int n : arr) {
	            if (n > max) {
	                max = n;
	            }
	        }
	        int[] count = new int[max + 1];
	        for (int n : arr) {
	            count[n]++;
	        }
	        int index = 0;
	        for (int i = 0; i < count.length; i++) {
	            while (count[i] > 0) {
	                arr[index++] = i;
	                count[i]--;
	            }
	        }
	    }
}