package com.json;

import org.json.JSONArray;
import org.json.JSONObject;

public class FilterJsonData {

	public static void main(String[] args) {
		String jsonData= """
	            [
	              {"name":"Suraj","age":22},
	              {"name":"Amit","age":28},
	              {"name":"Ravi","age":30},
	              {"name":"Neha","age":24}
	            ]
	            """;
		JSONArray users=new JSONArray(jsonData);
		
		for(int i=0;i<users.length();i++) {
			JSONObject obj=users.getJSONObject(i);
			int age=obj.getInt("age");
			
			if(age>25) {
				System.out.println(obj);
			}
		}
	}

}
