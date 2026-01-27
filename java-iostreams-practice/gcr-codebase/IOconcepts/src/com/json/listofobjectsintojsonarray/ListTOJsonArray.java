package com.json.listofobjectsintojsonarray;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ListTOJsonArray {

	public static void main(String[] args) throws JsonProcessingException {

		List<Student>students=new ArrayList<>();
		
		students.add(new Student("Allu",22));
		students.add(new Student("Bholu",25));
		students.add(new Student("Kali",21));
		students.add(new Student("Sonu",28));
		
		ObjectMapper mapper=new ObjectMapper();
		
		//convert list to JSON array
		String jsonArray=mapper.writeValueAsString(students);
		
		System.out.println(jsonArray);
	}

}
