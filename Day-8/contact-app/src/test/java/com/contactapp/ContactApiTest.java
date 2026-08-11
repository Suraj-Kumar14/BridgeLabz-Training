package com.contactapp;

import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class ContactApiTest {
	
	@Test
	void shouldGetAllContacts() {
		
		given()
		.when()
		.get("http://localhost:8080/contacts")
		.then()
		.statusCode(200);
	}
	
	@Test
	void shouldGetContactById() {
		
		given()
		.when()
		.get("http://localhost:8080/contacts/1")
		.then()
		.statusCode(200)
		.body("id",equalTo(1))
		.body("name", equalTo("Ankur Verma"));
	}
	
	@Test
	void shouldCreateContact() {
		
		String requestBody = """ 
		{
			"name": "Rahul kumar",
			"phone": "9878675476",
			"email": "rahul12@gmail.com",
			"address": "Delhi"
		}
		""";
				
		given()
				.contentType("application/json")
				.body(requestBody)
		.when()
				.post("http://localhost:8080/contacts")
		.then()
				.statusCode(201)
				.body("name", equalTo("Rahul kumar"))
				.body("email", equalTo("rahul12@gmail.com"));
				
	}
	
	@Test
	void shouldUpdateContact() {
		
		String requestBody ="""
				{
					"name": "Ankur Verma",
					"phone": "8798678781",
					"email": "ankur@gmail.com",
					"address": "Nawada"
				}
				""";
		
		given()
				.contentType("application/json")
				.body(requestBody)
		.when()
				.put("http://localhost:8080/contacts/1")
		.then()
				.statusCode(200)
				.body("name",equalTo("Ankur Verma"))
				.body("email",equalTo("ankur@gmail.com"));
	}
	
	@Test
	void shouldDeleteContact() {
		
		given()
		.when()
			.delete("http://localhost:8080/contacts/1")
		.then()
			.statusCode(204);
	}
	
	@Test
	void shouldReturn404WhenContactNotFound() {
		
		given()
		.when()
			.get("http://localhost:8080/contacts/99")
		.then()
			.statusCode(404);
	}
	
	@Test
	void shouldRejectInvalidContact() {

	    String requestBody = """
	        {
	            "name": "",
	            "phone": "12345",
	            "email": "wrong-email",
	            "address": ""
	        }
	        """;

	    given()
	        .contentType("application/json")
	        .body(requestBody)
	    .when()
	        .post("http://localhost:8080/contacts")
	    .then()
	        .statusCode(400);
	}
}
