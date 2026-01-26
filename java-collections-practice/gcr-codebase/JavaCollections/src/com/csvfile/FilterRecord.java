package com.csvfile;

import java.io.*;

public class FilterRecord {
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		try(BufferedReader br=new BufferedReader(new FileReader("textFiles/students.csv"))){
				
			String line;
			br.readLine();
			
			System.out.println("Students scoring more than 80 marks: ");
			while((line=br.readLine())!=null) {
				String[] data=line.split(",");
				int marks=Integer.parseInt(data[3]);
					if(marks>80) {
						int id=Integer.parseInt(data[0]);
						String name=data[1];
						
						int age=Integer.parseInt(data[2]);
						
						
						 System.out.println("Student ID : " + id);
			             System.out.println("Name       : " + name);
			             System.out.println("Age        : " + age);
			             System.out.println("Marks      : " + marks);
			             System.out.println("--------------------------");
					}	
			
			}
		}catch(FileNotFoundException e) {
			System.out.println("File not found!");
		}
	}
}
