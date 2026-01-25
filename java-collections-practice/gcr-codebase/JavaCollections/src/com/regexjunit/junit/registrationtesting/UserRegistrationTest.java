package com.regexjunit.junit.registrationtesting;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UserRegistrationTest {

	UserRegistration user;
	@BeforeEach
	void setUp() throws Exception {
		user=new UserRegistration();
	}

	@Test
	void testValidRegistration() {
		assertTrue(user.registerUser("Suraj0123","Suraj@123.com","Password12"));
	}

}
