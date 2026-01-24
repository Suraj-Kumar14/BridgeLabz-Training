package com.streams;

import java.io.*;
import java.util.HashMap;

public class CountWords {
	public static void main(String[] args) {
		try {
			BufferedReader read = new BufferedReader(new FileReader("textFiles/bigText.txt"));
			
			String line;
			
			HashMap<String,Integer> freq = new HashMap<>();
			int countWords = 0;
			
			while((line=read.readLine())!=null) {
				for(String word : line.split("\\s+")) {
					freq.put(word, freq.getOrDefault(word, 0)+1);	
					countWords+=1;
				}
			}
			
			System.out.println("Word Count: "+countWords);
			for(var c : freq.entrySet()) {
				System.out.println("\nWord: "+c.getKey());
				System.out.println("Occurence Count: "+c.getValue());
			}
		}
		catch(IOException e) {
			System.out.println("File not found!");
		}
	}
}
