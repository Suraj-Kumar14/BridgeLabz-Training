package com.streams;

import java.io.*;

public class ConvertToLowercase {

	public static void main(String[] args) throws FileNotFoundException {
		
		try(
		BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream("textFiles/bigText.txt")));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(new FileOutputStream("output.txt")));
		){
			int ch;
			while((ch=br.read())!=-1) {
				bw.write(Character.toLowerCase((char)ch));
				
			}
			System.out.println("File converted to lowercase successfully.");
			
		}catch(IOException e) {
			System.out.println("IO Error occured!");
		}
	}

}
