package com.streams;

import java.io.*;

public class ImageToByteArray {
		
	public static void main(String[] args) throws Exception{
		try
		{
			FileInputStream file = new FileInputStream("textFiles/firstImage.jpg");
				
			ByteArrayOutputStream bytes = new ByteArrayOutputStream();
				
			int b;
			while((b=file.read())!=-1) {
				bytes.write(b);
			}
				
			byte[] arrayByte = bytes.toByteArray();
				
			FileOutputStream result = new FileOutputStream("textFiles/copyImage.jpg");
			result.write(arrayByte);
			
		}catch(Exception e) {
			System.out.println("File not found!");
		}
	}

}
