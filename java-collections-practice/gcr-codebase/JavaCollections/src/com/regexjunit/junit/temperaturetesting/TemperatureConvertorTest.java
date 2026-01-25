package com.regexjunit.junit.temperaturetesting;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TemperatureConvertorTest {

	TemperatureConvertor temp;
	@BeforeEach
	void setUp() throws Exception {
		temp=new TemperatureConvertor();
	}

	@Test
	void testCelsiusToFahrenheit() {
		assertEquals(98.6,temp.celsiusToFahrenheit(37));
	}

	@Test
	void testFahrenheitToCelsius() {
		assertEquals(25,temp.fahrenheitToCelsius(77));
	}

}
