package com.searchingalgorithms;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class InputStreamReaderEx {

    public static void main(String[] args) {

        String filePath = "example.txt"; // Path to the file

        try {
            // Step 1: Read binary data
            FileInputStream fileInputStream = new FileInputStream(filePath);

            // Step 2: Convert byte stream to character stream (UTF-8)
            InputStreamReader inputStreamReader =
                    new InputStreamReader(fileInputStream, StandardCharsets.UTF_8);

            // Step 3: Buffer for efficient reading
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            String line;

            // Step 4: Read and print file line by line
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }

            // Step 5: Close resources
            bufferedReader.close();
            inputStreamReader.close();
            fileInputStream.close();

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
