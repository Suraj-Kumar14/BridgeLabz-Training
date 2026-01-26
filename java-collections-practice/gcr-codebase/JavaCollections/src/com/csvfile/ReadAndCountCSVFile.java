package com.csvfile;

import java.io.*;

public class ReadAndCountCSVFile {

	public static void main(String[] args) throws IOException {
		
		try(BufferedReader br=new BufferedReader(new FileReader("textFiles/students.csv"))){
			
			String line;
			int count=0;
			
			while((line=br.readLine())!=null) {
				if(!line.trim().isEmpty()) {
					count++;
				}
			}
			
			System.out.println("Total employee records: "+count);
		}catch(IOException e) {
			System.out.println("Error reading csv file.");
		}
	}	
}
