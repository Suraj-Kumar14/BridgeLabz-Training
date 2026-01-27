package com.csvfile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FilterRecords {

	public static void main(String[] args) {
		try(BufferedReader br=new BufferedReader(new FileReader("DataFiles/students.csv"))){
			
			String line;
			br.readLine();
			
			
			while((line=br.readLine())!=null) {
				String data[]=line.split(",");
			
				int marks=Integer.parseInt(data[3]);
				if(marks>80) {
					int id=Integer.parseInt(data[0]);
					String name=data[1];
					int age=Integer.parseInt(data[2]);
					
					System.out.println("-------Student data---------");
					System.out.println("ID: "+id);
					System.out.println("Name: "+name);
					System.out.println("Age: "+age);
					System.out.println("Marks: "+marks);
				}
				
			}
			
			
		} catch (IOException e1) {
			System.out.println("Error while reading file");
		}


	}

}
