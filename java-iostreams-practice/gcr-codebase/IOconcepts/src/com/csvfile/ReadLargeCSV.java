package com.csvfile;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadLargeCSV {
	private static final int CHUNK_SIZE = 100;

    public static void main(String[] args) {

        int totalRecords = 0;
        List<String> buffer = new ArrayList<>(CHUNK_SIZE);

        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(new FileInputStream("large.csv")))) {

            String line;

            br.readLine(); 

            while ((line = br.readLine()) != null) {

                buffer.add(line);
                totalRecords++;

                // When buffer reaches 100 lines, process it
                if (buffer.size() == CHUNK_SIZE) {
                    processChunk(buffer);
                    buffer.clear(); // free memory
                    System.out.println("Records processed: " + totalRecords);
                }
            }

            // Process remaining lines (<100)
            if (!buffer.isEmpty()) {
                processChunk(buffer);
                System.out.println("Records processed: " + totalRecords);
            }

        } catch (IOException e) {
            System.out.println("Error reading large CSV file");
        }
    }

    private static void processChunk(List<String> chunk) {
        System.out.println("Processing chunk of size: " + chunk.size());
    }

}
