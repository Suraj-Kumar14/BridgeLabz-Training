package com.csvfile;

import java.io.*;

public class ModifyCSVFile {
	
	public static void main(String[] args) {

        String inputFile = "DataFiles/employees.csv";
        String outputFile = "DataFiles/updated_employees.csv";

        try (
            BufferedReader br = new BufferedReader(new FileReader(inputFile));
            BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))
        ) {

            String line;

            // Read and write header
            line = br.readLine();
            bw.write(line);
            bw.newLine();

            // Process records
            while ((line = br.readLine()) != null) {

                String[] data = line.split(",");

                int id = Integer.parseInt(data[0].trim());
                String name = data[1].trim();
                String department = data[2].trim();
                int salary = Integer.parseInt(data[3].trim());

                // Increase salary by 10% for IT department
                if (department.equalsIgnoreCase("IT")) {
                    salary = salary + (salary * 10 / 100);
                }

                // Write updated record
                bw.write(id + "," + name + "," + department + "," + salary);
                bw.newLine();
            }

            System.out.println("Salary updated successfully!");
            System.out.println("New file created: " + outputFile);

        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        } catch (IOException e) {
            System.out.println("Error processing file!");
        } catch (NumberFormatException e) {
            System.out.println("Invalid number format in CSV!");
        }
		}
}
