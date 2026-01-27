package com.json;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonValidation {
    public static void main(String[] args) {
        String json = "{ \"name\": \"Suraj\", \"age\": 22 }";

        ObjectMapper mapper = new ObjectMapper();

        try {
            mapper.readTree(json);   // parses JSON
            System.out.println("Valid JSON");
        } catch (Exception e) {
            System.out.println("Invalid JSON");
        }
    }
}