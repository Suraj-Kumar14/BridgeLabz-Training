package com.csvfile.convertcsvtoobject;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CSVtoStudent {
	public static void main(String[] args) {

        List<Student> students = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("DataFiles/students.csv"))) {

            String line;
            br.readLine(); // skip header

            while ((line = br.readLine()) != null) {

                String[] data = line.split(",");

                int id = Integer.parseInt(data[0].trim());
                String name = data[1].trim();
                String branch = data[2].trim();
                int marks = Integer.parseInt(data[3].trim());

                Student student = new Student(id, name, branch, marks);
                students.add(student);
            }

        } catch (IOException e) {
            System.out.println("Error reading CSV file");
        }

        // Print student objects
        System.out.println("Student Details:");
        System.out.println("-------------------------");
        for (Student s : students) {
            System.out.println(s);
        }
    }
}
