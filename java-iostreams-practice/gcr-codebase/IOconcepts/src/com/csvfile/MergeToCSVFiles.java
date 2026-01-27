package com.csvfile;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class MergeToCSVFiles {
	public static void main(String[] args) {

        Map<String, String[]> map = new HashMap<>();

        try (
            BufferedReader r1 = new BufferedReader(
                new InputStreamReader(new FileInputStream("DataFiles/students1.csv")));
            BufferedReader r2 = new BufferedReader(
                new InputStreamReader(new FileInputStream("DataFiles/students2.csv")));
            BufferedWriter w = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream("DataFiles/mergestudent.csv")))
        ) {

            String line;

            // skip header of first file
            r1.readLine();

            // read student1.csv
            while ((line = r1.readLine()) != null) {
                String[] data = line.split(",");
                map.put(data[0].trim(), data); 
            }

            // write header
            w.write("ID,Name,Age,Marks,Grade");
            w.newLine();

            // skip header of second file
            r2.readLine();

            // read student2.csv and merge
            while ((line = r2.readLine()) != null) {
                String[] data2 = line.split(",");
                String id = data2[0].trim();

                if (map.containsKey(id)) {
                    String[] data1 = map.get(id);

                    w.write(id + "," +
                            data1[1] + "," +
                            data1[2] + "," +
                            data2[1] + "," +
                            data2[2]);
                    w.newLine();
                }
            }

            System.out.println("Merge completed successfully");

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
