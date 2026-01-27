package com.json;

import org.json.JSONObject;

public class MergeJson {

	public static void main(String[] args) {
		
		JSONObject json1=new JSONObject();
		json1.put("ID",101);
		json1.put("name","Suraj");
		
		JSONObject json2=new JSONObject();
		json2.put("Email", "suraj@gmail.com");
		json2.put("Age", 22);
		
		//merge two json
		for(String key: json2.keySet()) {
			json1.put(key, json2.get(key));
		}
		
		System.out.println(json1.toString());
	}

}
