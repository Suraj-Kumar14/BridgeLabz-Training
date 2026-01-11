package com.searchingalgorithms;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileReadExample {
	public static void main(String[] args) {
		
		String filePath="example.txt";
		
		try {
			FileReader fileReader=new FileReader(filePath);
			BufferedReader bufferedReader=new BufferedReader(fileReader);
			
			String line;
			//Read file line by line
			while((line=bufferedReader.readLine())!=null) {
				System.out.println(line);
			}
			
			//close the file
			bufferedReader.close();
			fileReader.close();
		}catch(IOException e) {
			System.out.println("Error reading file: "+e.getMessage());
		}
	}
	
}
