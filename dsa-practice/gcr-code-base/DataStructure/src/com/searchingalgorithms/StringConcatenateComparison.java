package com.searchingalgorithms;

public class StringConcatenateComparison {
	
	    public static void main(String[] args) {
	        int iterations = 1_000_000;
	        String text = "hello";

	        // Test StringBuffer
	        StringBuffer sbuffer = new StringBuffer();
	        long startTime = System.nanoTime();
	        for (int i = 0; i < iterations; i++) {
	            sbuffer.append(text);
	        }
	        long endTime = System.nanoTime();
	        long bufferTime = endTime - startTime;

	        // Test StringBuilder
	        StringBuilder sbuilder = new StringBuilder();
	        startTime = System.nanoTime();
	        for (int i = 0; i < iterations; i++) {
	            sbuilder.append(text);
	        }
	        endTime = System.nanoTime();
	        long builderTime = endTime - startTime;

	        // Results
	        System.out.println("Time taken by StringBuffer: " + bufferTime / 1_000_000 + " ms");
	        System.out.println("Time taken by StringBuilder: " + builderTime / 1_000_000 + " ms");
	    }
}

