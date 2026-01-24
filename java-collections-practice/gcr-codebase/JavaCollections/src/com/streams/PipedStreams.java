package com.streams;

import java.io.*;
import java.nio.charset.StandardCharsets;
public class PipedStreams {

	public static void main(String[] args) {
		try {
			PipedOutputStream addData = new PipedOutputStream();
			PipedInputStream readData = new PipedInputStream();
			
			 // writer needs to connect to the reader's input stream
			addData.connect(readData);
			
			//creating the write thread
			Thread writeThread = new Thread(() -> {
				try {
					System.out.println("\nWrite thread-");
					String message = "Hello world";
					addData.write(message.getBytes(StandardCharsets.UTF_8));
					System.out.println("message sent- "+message);
				}
				catch(Exception e) {
					e.printStackTrace();
				}
				finally {
					try {
						addData.close();
					}
					catch(IOException e) {
						e.printStackTrace();
					}
				}
			});
			
			
			//creating thread to read 
			Thread readThread = new Thread(()->{
				try {
					byte[] buffer = new byte[4096];
					int byteRead = readData.read(buffer);
					System.out.println("byte read int: \n"+byteRead);
					System.out.println("buffer int[]: \n"+buffer.toString());
					if(byteRead!=-1) {
						String message = new String(buffer,0,byteRead);
						System.out.println("\nRead Thread : message-");
						System.out.println(message);
					}
				}
				catch(Exception e) {
					System.out.println("");
				}finally {
					try {
						readData.close();
					}
					catch(IOException e) {
						e.printStackTrace();
					}
				}
			});
			
			writeThread.start();
			readThread.start();
			
		}
		catch(Exception e) {
			System.out.println("File Not found!");
		}
	}
}