package com.streams;

import java.io.*;

public class ReadTextFile {

	public static void main(String[] args) throws IOException {
		

		try(BufferedWriter w=new BufferedWriter(new OutputStreamWriter(new FileOutputStream("textFiles/newText.txt")))){
			String line;
			BufferedReader read=new BufferedReader(new InputStreamReader(new FileInputStream("textFiles/bigText.txt")));
			while((line=read.readLine())!=null) {
				w.write(line);
			}
			read.close();
			System.out.println("copy success.");
		}catch(FileNotFoundException e) {
			System.out.println("File not found!");
		}	
	}

}
