package com.timecomplexity;

public class CompareStringStringbuilderStringbuffer {
	private static String stringConcatanation(String str) {
		for(int i=0; i<1000; i++) {
			str += 'a';
		}
		return str;
	}
	private static String stringbuilderConcatanation(String str) {
		StringBuilder sb = new StringBuilder(str);
		for(int i=0; i<1000; i++) {
			sb.append('a');
		}
		return sb.toString();
	}
	private static String stringbufferConcatanation(String str) {
		StringBuffer sb = new StringBuffer(str);
		for(int i=0; i<1000; i++) {
			sb.append('a');
		}
		return sb.toString();
	}
	public static void main(String[] args) {
		String str = "Hello World";
		
		long stringStartTime = System.nanoTime();
		String s1 = stringConcatanation(str);
		long stringEndTime = System.nanoTime();
		System.out.println("String uses : " + (stringEndTime - stringStartTime) + " time for concatanation of strings");
		
		long stringbuilderStartTime = System.nanoTime();
		String s2 = stringbuilderConcatanation(str);
		long stringbuilderEndTime = System.nanoTime();
		System.out.println("Stringbuilder uses : " + (stringbuilderEndTime - stringbuilderStartTime) + " time for concatanation of strings");
		
		long stringbufferStartTime = System.nanoTime();
		String s3 = stringbufferConcatanation(str);
		long stringbufferEndTime = System.nanoTime();
		System.out.println("Stringbuffer uses : " + (stringbufferEndTime - stringbufferStartTime) + " time for concatanation of strings");
	}	
}