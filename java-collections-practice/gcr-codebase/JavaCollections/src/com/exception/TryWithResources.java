package com.exception;

import java.io.*;

public class TryWithResources {

	public static void main(String[] args) throws IOException {
		
		try(BufferedReader read=new BufferedReader(new FileReader("textFiles/bigText.txt"))){
			String line;
			while((line=read.readLine())!=null) {
				System.out.println(line);
			}
		}catch(FileNotFoundException e) {
			System.out.println("Error reading file.");
		}
		
	}

}
