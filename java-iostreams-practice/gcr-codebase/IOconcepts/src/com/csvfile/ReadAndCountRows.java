package com.csvfile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadAndCountRows {

	public static void main(String[] args) {
		try(BufferedReader br=new BufferedReader(new FileReader("DataFiles/students.csv"))){
			
			String line;
			br.readLine();
			int count=0;
			
			while((line=br.readLine())!=null) {
				String data[]=line.split(",");
				
				int id=Integer.parseInt(data[0]);
				String name=data[1];
				int age=Integer.parseInt(data[2]);
				int marks=Integer.parseInt(data[3]);
				
				System.out.println("-------Student data---------");
				System.out.println("ID: "+id);
				System.out.println("Name: "+name);
				System.out.println("Age: "+age);
				System.out.println("Marks: "+marks);
				
				count++;
			}
			
			System.out.println("\nTotal rows: "+count);
		} catch (IOException e1) {
			System.out.println("Error while reading file");
		}


	}

}
