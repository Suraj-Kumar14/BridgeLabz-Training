package com.streams;

import java.io.*;

public class RaedLargeFile {
	public static void main(String[] args) {
		try {
			BufferedReader read = new BufferedReader(
				new InputStreamReader(
						new FileInputStream("textFiles/bigText.txt")
					));
			
			String line;
			while((line=read.readLine())!=null) {
				if(line.contains("error")) {
					System.out.println(line);
				}
			}
			
			read.close();
		}
		catch(IOException e) {
			System.out.println("File not found!");
		}
	}
}
