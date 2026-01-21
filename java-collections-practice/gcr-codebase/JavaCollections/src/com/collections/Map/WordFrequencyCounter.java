package com.collections.Map;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class WordFrequencyCounter {
	
	public static void main(String[] args) {
		
		String filePath="C:\\Users\\suraj\\OneDrive\\Documents\\input.txt";
		
		HashMap<String,Integer>wordCount=new HashMap<>();
		
		try(BufferedReader br=new BufferedReader(new FileReader(filePath))){
			String line;
			
			while((line=br.readLine())!=null) {
				line=line.toLowerCase().replaceAll("[^a-zA-Z0-9\\s]", "");
				
				String[] words=line.split("\\s+");
				
				for(String word: words) {
					if(!word.isEmpty()) {
						wordCount.put(word, wordCount.getOrDefault(word,0)+1);
					}
				}
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
		System.out.println(wordCount);
	}

}
