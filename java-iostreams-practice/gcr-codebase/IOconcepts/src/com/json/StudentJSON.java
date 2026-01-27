package com.json;

import org.json.JSONArray;
import org.json.JSONObject;

public class StudentJSON {

	public static void main(String[] args) {
		
		//Create JSON object
		JSONObject student=new JSONObject();
		student.put("name","Suraj");
		student.put("age", 22);
		
		//Create subjects array
		JSONArray subjects=new JSONArray();
		subjects.put("Maths");
        subjects.put("Physics");
        subjects.put("Computer Science");
		
		//add array to object
        student.put("subjects",subjects );
        
        //print JSON
        System.out.println(student.toString());

	}

}
