package com.csvfile;

import java.io.*;
import java.util.Scanner;

public class SearchRecord {
	
public static void main(String[] args)  {
		
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter name to search: ");
		String user=sc.nextLine().trim();
		boolean found=false;
		
		try(BufferedReader br=new BufferedReader(new FileReader("employees.csv"))){
				
			String line;
			//skip header
			br.readLine();
			
			System.out.println("-------Employee Details------- ");
			while((line=br.readLine())!=null) {
				String[] data=line.split(",");
				if(data.length<4) 
					continue;
				String name=data[1].trim();
					if(name.equalsIgnoreCase(user)) {
						found=true;
						//int id=Integer.parseInt(data[0]);
						
						String department=data[2].trim();
						int salary=Integer.parseInt(data[3].trim());
						
			             System.out.println("Name       : " + name);
			             System.out.println("Department : " + department);
			             System.out.println("Salary     : " + salary);
			             System.out.println("--------------------------");
					}	
			}
			if(!found) {
				System.out.println("Employee not found!");
			}
		}catch(FileNotFoundException e) {
			System.out.println("File not found!");
		}catch (IOException e) {
            System.out.println("Error reading file!");
        } catch (NumberFormatException e) {
            System.out.println("Invalid salary format!");
        }
		sc.close();
	}
}
