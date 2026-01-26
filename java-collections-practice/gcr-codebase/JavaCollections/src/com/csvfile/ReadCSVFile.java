package com.csvfile;

import java.io.*;

public class ReadCSVFile {
	
	public static void main(String[] args) throws IOException {
		
		String filePath="textFiles/students.csv";
		String line;
		
		try (BufferedReader br= new BufferedReader(new FileReader(filePath))){
			
			br.readLine();
			while((line=br.readLine())!=null) {
				String[] data=line.split(",");
				
				int id=Integer.parseInt(data[0]);
				String name=data[1];
				
				int age=Integer.parseInt(data[2]);
				int marks=Integer.parseInt(data[3]);
				
				 System.out.println("Student ID : " + id);
	             System.out.println("Name       : " + name);
	             System.out.println("Age        : " + age);
	             System.out.println("Marks      : " + marks);
	             System.out.println("--------------------------");
			} 
		}catch (IOException e) {
            System.out.println("Error reading CSV file");
        }
	}
}
