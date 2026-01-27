package com.json;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.JSONObject;

public class ReadJsonFileExtractField {

	public static void main(String[] args) throws IOException {
		
		String content=new String (Files.readAllBytes(Paths.get("DataFiles/students.json")));
		
		JSONObject obj=new JSONObject(content);
		
		String name=obj.getString("name");
		String email=obj.getString("email");
		
		System.out.println("Name: "+name);
		System.out.println("Email: "+email);
	}

}
