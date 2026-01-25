package com.regexjunit.junit.listoperationtesting;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ListManagerTest {

	List<Integer>list;
	ListManager manager;
	@BeforeEach
	void setUp() throws Exception {
		manager=new ListManager();
		list=new ArrayList<>();
	}

	@Test
	void testAddElement() {
		manager.addElement(list, 13);
		manager.addElement(list, 5);
		
		assertTrue(list.contains(13));
		assertTrue(list.contains(5));
		
		assertEquals(2,manager.getSize(list));
	}

	@Test
	void testRemoveElement() {
		list.add(10);
		list.add(12);
		
		manager.removeElement(list, 10);
		
		assertFalse(list.contains(10));
		assertTrue(list.contains(12));
		assertEquals(1,manager.getSize(list));
	}

}
