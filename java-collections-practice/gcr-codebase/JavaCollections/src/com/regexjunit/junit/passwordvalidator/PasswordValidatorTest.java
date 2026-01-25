package com.regexjunit.junit.passwordvalidator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PasswordValidatorTest {

	PasswordValidator password;
	@BeforeEach
	void setUp() throws Exception {
		password=new PasswordValidator();
	}

	@Test
	void testCheckPassword() {
		assertTrue(password.checkPassword("Suraj1234"));
	}

}
