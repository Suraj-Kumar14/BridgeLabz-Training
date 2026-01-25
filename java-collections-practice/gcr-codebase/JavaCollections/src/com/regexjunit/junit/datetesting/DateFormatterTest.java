package com.regexjunit.junit.datetesting;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DateFormatterTest {

	DateFormatter formatter;
	@BeforeEach
	void setUp() throws Exception {
		formatter=new DateFormatter();
	}

	@Test
	void testFormatDate() {
		assertEquals("26-01-2026",formatter.formatDate("2026-01-26"));
	}

}
