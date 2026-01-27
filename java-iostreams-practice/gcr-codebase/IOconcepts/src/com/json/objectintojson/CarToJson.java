package com.json.objectintojson;

import com.google.gson.Gson;

public class CarToJson {

	public static void main(String[] args) {
		
		Car car=new Car("Toyota", "Innova", 2022,2500000);
		
		Gson gson=new Gson();
		String json=gson.toJson(car);
		
		System.out.println(json);
	}

}
