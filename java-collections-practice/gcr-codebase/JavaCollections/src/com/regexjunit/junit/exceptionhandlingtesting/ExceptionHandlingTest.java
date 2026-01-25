package com.regexjunit.junit.exceptionhandlingtesting;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ExceptionHandlingTest {

	ExceptionHandling ex;
	@BeforeEach
	void setUp()  {
		ex=new ExceptionHandling();
	}

	@Test
	void testDivideByZero() {
		ArithmeticException exception=assertThrows(ArithmeticException.class,()->ex.divide(10,0));
		
		assertEquals("Cannot divide by zero.",exception.getMessage());
	}

}
