package com.searchingalgorithms;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class WordCountExample {
	public static void main(String[] args) {
		
		String filePath="example.txt";
		String targetWord="hello";
		int count=0;
		
		try {
			FileReader fileReader=new FileReader(filePath);
			BufferedReader bufferedReader=new BufferedReader(fileReader);
			
			String line;
			
			while((line=bufferedReader.readLine())!=null) {
				String[] words=line.split("\\s+");
				
				for(String word:words) {
					if(word.equals(targetWord)) {
						count++;
					}
				}
			}
			bufferedReader.close();
			fileReader.close();
			
			System.out.println("Thr word \""+ targetWord+"\"appears"+count+"times.");
			
		}catch(IOException e) {
			System.out.println("Error reading file: "+e.getMessage());
		}
	}
}
