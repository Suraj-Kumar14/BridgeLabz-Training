package com.regexjunit.junit.parameterizedtesting;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.provider.ValueSources;

class NumberTest {

	Number num;
	@BeforeEach
	void setUp() throws Exception {
		num=new Number();
	}

	@ParameterizedTest
	@ValueSource(ints = {2, 4, 6,7,9})
	void testIsEven(int number) {
		boolean expected=number%2==0;
		assertEquals(expected,num.isEven(number));
	}

}
