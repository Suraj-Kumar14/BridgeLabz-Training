package com.csvfile;

import java.io.*;

public class WriteCSVFile {

	public static void main(String[] args) throws IOException {
		
		try(FileWriter w=new FileWriter("employees.csv")){
			
			String.valueOf(w.append("101, Suraj, IT, 45000\n"));
			w.append("102, Allu, HR, 40000\n");
			w.append("103, Rahul, Manager, 85000\n");
			w.append("104, Satyam, IAS, 150000\n");
			w.append("105, Shivam, ADM, 95000\n");
			
			System.out.println("CSV file created and data written successfully.");
			
			
		}catch(IOException e) {
			System.out.println("Error writting to csv file.");
		}

	}

}
