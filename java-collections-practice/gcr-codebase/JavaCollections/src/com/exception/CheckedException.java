package com.exception;

import java.io.*;

public class CheckedException {

	public static void main(String[] args) throws IOException{
		
		try {
			BufferedReader read=new BufferedReader(new FileReader("textFiles/read.txt"));
			String line;
			while((line=read.readLine())!=null) {
				System.out.println(line);
			}
			read.close();
		}catch(FileNotFoundException e) {
			System.out.println("File not found!");
		} 
	}

}
