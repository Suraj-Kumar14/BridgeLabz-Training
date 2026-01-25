package com.regexjunit.junit.calculatortesting;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalculatorTest {

	Calculator calc;
	@BeforeEach
	void setUp() throws Exception {
		calc=new Calculator();
	}

	@Test
	void testAdd() {
		assertEquals(15,calc.add(10, 5));		
	}

	@Test
	void testSubtract() {
		assertEquals(10,calc.subtract(15, 5));
	}

	@Test
	void testMultiply() {
		assertEquals(25,calc.multiply(5, 5));
	}

	@Test
	void testDivision() {
		assertEquals(5,calc.division(10, 2));
	}
	
	@Test
	void testDivideByZero() {
		assertThrows(ArithmeticException.class, ()-> {calc.division(10,0);});
	}

}
