package com.regexjunit.junit.stringtesting;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StringUtilsTest {
	
	StringUtils utils;
	@BeforeEach
	void setUp() throws Exception {
		utils=new StringUtils();
	}

	@Test
	void testReverse() {
		assertEquals("olleh",utils.reverse("hello"));
	}

	@Test
	void testIsPalindrome() {
		assertEquals(true,utils.isPalindrome("ABBA"));
	}

	@Test
	void testToUpperCase() {
		assertEquals("HELLO",utils.toUpperCase("hello"));
	}

}
