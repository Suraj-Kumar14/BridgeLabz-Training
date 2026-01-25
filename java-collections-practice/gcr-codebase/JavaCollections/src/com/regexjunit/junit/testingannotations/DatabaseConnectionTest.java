package com.regexjunit.junit.testingannotations;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DatabaseConnectionTest {
	DatabaseConnection db;
	@BeforeEach
	void setUp() throws Exception {
		db=new DatabaseConnection();
		db.connect();
	}

	@AfterEach
	void testDisconnect() {
		db.disconnect();
	}

	@Test
	void testIsConnected() {
		assertTrue(db.isConnected(),"false");		
	}
	
}
