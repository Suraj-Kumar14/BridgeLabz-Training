package com.csvfile;

import java.io.*;

public class WriteDataToCSVFile {

	public static void main(String[] args) {
		
		try(FileWriter w=new FileWriter("DataFiles/employees.csv")){
			
			w.append("101,Allu,25,25000\n");
			w.append("102,Sonu,30,45000\n");
			w.append("103,Monu,22,35000\n");
			w.append("104,Bholu,28,32000\n");
			w.append("105,Kali,31,55000\n");
			
			System.out.println("CSV file write successfully!");					
			
			
		} catch (IOException e1) {
			System.out.println("Error while reading file");
		}

	}

}
