package com.csvfile;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;

public class JsonCsvConverter {
	 
	 // JSON -> CSV
    public static void jsonToCsv(String jsonFile, String csvFile) {
        try {
            String content = new String(java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(jsonFile)));
            JSONArray jsonArray = new JSONArray(content);

            BufferedWriter bw = new BufferedWriter(new FileWriter(csvFile));

            // Write CSV header
            bw.write("id,name,age,marks");
            bw.newLine();

            // Write CSV rows
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject obj = jsonArray.getJSONObject(i);
                bw.write(
                        obj.getInt("id") + "," +
                        obj.getString("name") + "," +
                        obj.getInt("age") + "," +
                        obj.getInt("marks")
                );
                bw.newLine();
            }

            bw.close();
            System.out.println("JSON converted to CSV successfully!");

        } catch (Exception e) {
            System.out.println("Error converting JSON to CSV: " + e.getMessage());
        }
    }

    // CSV -> JSON
    public static void csvToJson(String csvFile, String jsonFile) {
        JSONArray jsonArray = new JSONArray();
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            String line;
            String[] headers = br.readLine().split(","); // read header

            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                JSONObject obj = new JSONObject();
                for (int i = 0; i < headers.length; i++) {
                    String key = headers[i].trim();
                    String val = values[i].trim();

                    // Convert numeric fields to integer
                    if (key.equals("id") || key.equals("age") || key.equals("marks")) {
                        obj.put(key, Integer.parseInt(val));
                    } else {
                        obj.put(key, val);
                    }
                }
                jsonArray.put(obj);
            }

            // Write JSON to file
            BufferedWriter bw = new BufferedWriter(new FileWriter(jsonFile));
            bw.write(jsonArray.toString(4)); // pretty print
            bw.close();

            System.out.println("CSV converted back to JSON successfully!");

        } catch (Exception e) {
            System.out.println("Error converting CSV to JSON: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        jsonToCsv("DataFiles/student.json", "DataFiles/student.csv");
        csvToJson("DataFiles/student.csv", "DataFiles/students_back.json");
    }
}
