package com.regexjunit.junit.filehandlingmethod;

import java.io.*;

public class FileProcessor {
	
	public boolean writeToFile(String filename,String content) throws IOException {
		BufferedWriter w=new BufferedWriter(new OutputStreamWriter(new FileOutputStream("textFiles/"+filename)));
	
		w.write(content);
		w.close();
		System.out.println("Content added.");
		
		return true;
	}
	
	public boolean readFromFile(String filename) throws IOException {
		BufferedReader read=new BufferedReader(new InputStreamReader(new FileInputStream("textFiles/"+filename)));
		
		String line;
		while((line=read.readLine())!=null) {
			System.out.println(line);
		}
		read.close();
		return true;
	}
}
