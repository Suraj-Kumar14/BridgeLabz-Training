package com.json;

import java.io.File;
import java.util.Iterator;
import java.util.Map;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ReadJson {

	 public static void main(String[] args) throws Exception {

	        ObjectMapper mapper = new ObjectMapper();
	        JsonNode rootNode = mapper.readTree(new File("DataFiles/students.json"));

	        printJson(rootNode);
	    }

	    // Recursive method
	    static void printJson(JsonNode node) {
	        if (node.isObject()) {
	            @SuppressWarnings("deprecation")
				Iterator<Map.Entry<String, JsonNode>> fields = node.fields();
	            while (fields.hasNext()) {
	                Map.Entry<String, JsonNode> entry = fields.next();
	                System.out.println(entry.getKey() + " : " + entry.getValue());
	                printJson(entry.getValue());
	            }
	        } else if (node.isArray()) {
	            for (JsonNode item : node) {
	                printJson(item);
	            }
	        }
	    }

}
