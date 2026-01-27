package com.csvfile;

import java.io.*;
import java.util.*;

public class DetectDuplicateCSV {
	
	  public static void main(String[] args) {
		  
      Set<String> seenIds = new HashSet<>();
      try (BufferedReader reader = new BufferedReader(new FileReader("DataFiles/duplicate.csv"))) {
          String line;

          // skip header
          reader.readLine();

           while ((line = reader.readLine()) != null) {

        	String[] data = line.split(",");

        	String id = data[0].trim();

        	if (!seenIds.add(id)) {
                System.out.println("Duplicate record found:");
                System.out.println(line);
              
	           }
	         }

      	} catch (IOException e) {
    	   System.out.println(e.getMessage());
        }
      
	 }
}
