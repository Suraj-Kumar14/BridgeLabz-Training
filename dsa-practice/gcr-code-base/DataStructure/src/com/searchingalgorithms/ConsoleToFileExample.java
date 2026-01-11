package com.searchingalgorithms;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileWriter;
import java.io.IOException;

public class ConsoleToFileExample {

    public static void main(String[] args) {

        String filePath = "output.txt"; 

        try {
            //Read input from console
            InputStreamReader inputStreamReader =
                    new InputStreamReader(System.in);
            BufferedReader bufferedReader =
                    new BufferedReader(inputStreamReader);

            //Write to file
            FileWriter fileWriter = new FileWriter(filePath, true); // append mode

            String input;

            System.out.println("Enter text (type 'exit' to stop):");

            //Read input and write to file
            while ((input = bufferedReader.readLine()) != null) {

                if (input.equalsIgnoreCase("exit")) {
                    break;
                }

                fileWriter.write(input);
                fileWriter.write(System.lineSeparator());
            }

            //Close resources
            fileWriter.close();
            bufferedReader.close();
            inputStreamReader.close();

            System.out.println("Input saved to file successfully.");

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
