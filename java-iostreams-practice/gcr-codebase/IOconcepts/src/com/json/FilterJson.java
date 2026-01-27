package com.json;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class FilterJson {
    public static void main(String[] args) throws Exception {

        String json = "[{\"name\":\"Suraj\",\"age\":22}," +
                      "{\"name\":\"Amit\",\"age\":28}," +
                      "{\"name\":\"Rahul\",\"age\":30}," +
                      "{\"name\":\"Neha\",\"age\":24}]";

        ObjectMapper mapper = new ObjectMapper();
        JsonNode rootArray = mapper.readTree(json);

        System.out.println("People with age > 25:");

        for (JsonNode node : rootArray) {
            if (node.get("age").asInt() > 25) {
                System.out.println(node);
            }
        }
    }
}