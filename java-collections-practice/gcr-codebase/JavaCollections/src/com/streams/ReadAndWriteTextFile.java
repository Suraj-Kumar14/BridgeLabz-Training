package com.streams;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.*;

public class ReadAndWriteTextFile {

	public static void main(String[] args) throws IOException {
		
		
		
		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Name: ");
		String name=reader.readLine();
		
		System.out.print("Enter Age: ");
		int age=Integer.parseInt(reader.readLine());
		
		System.out.print("Enter college: ");
		String college=reader.readLine();
		
		FileOutputStream filepath = new FileOutputStream("textFiles/read.txt");
		
		try (BufferedWriter w = new BufferedWriter(new OutputStreamWriter(filepath))){
			w.write(name);
			w.write(String.valueOf("\n"));
			w.write(String.valueOf(age));
			w.write(String.valueOf("\n"));
			w.write(college);
			System.out.println("Added file data.");
		}
		catch(FileNotFoundException e) {
			System.out.println("File not found.");
		}
	}

}
