package com.csvfile;

import java.io.*;
import java.util.Scanner;

public class SearchRecord {
	static Scanner sc=new Scanner(System.in);
public static void main(String[] args) {
	
		try{
			BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream("DataFiles/employees.csv")));
			String line = br.readLine();
			
			System.out.print("Enter employees name: ");
			String user=sc.nextLine();
			
			while((line=br.readLine())!=null) {
				String data[]=line.split(",");				
				
				String name=data[1].trim();
				if(name.equalsIgnoreCase(user)) {
					String depart=data[2].trim();
					int salary=Integer.parseInt(data[3].trim());
					
					System.out.println("-------Employees data---------");				
					System.out.println("Department: "+depart);
					System.out.println("Age: "+salary);						
				}
			}
			
			br.close();
		} catch (IOException e1) {
			System.out.println("Error while reading file");
		}
	}
}
