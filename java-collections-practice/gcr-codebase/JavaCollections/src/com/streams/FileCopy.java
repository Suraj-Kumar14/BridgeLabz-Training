package com.streams;

import java.io.*;


public class FileCopy {

	public static void main(String[] args) throws IOException {
		
		
		try(BufferedWriter w=new BufferedWriter(new OutputStreamWriter(new FileOutputStream("textFiles/newbigText.txt")))){
			String line;
			BufferedReader read=new BufferedReader(new InputStreamReader(new FileInputStream("textFiles/bigText.txt")));
			while((line=read.readLine())!=null) {
				w.write(line);
				w.write(String.valueOf("\nTime:"));
				w.write(String.valueOf(System.nanoTime()));
			}
			read.close();
			System.out.println("copy success.");
		}catch(FileNotFoundException e) {
			System.out.println("File not found!");
		}	
	}
}
