package com.contactapp.controller;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import com.contactapp.dto.ContactDTO;
import com.contactapp.exception.ContactNotFoundException;
import com.contactapp.service.ContactServiceImpl;

public class ContactControllerTest {

	@Mock
	private ContactServiceImpl service;
	
	@InjectMocks
	private ContactController controller;
	
	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
	public void ShouldGetAllContact() {
		
		ContactDTO contact = new ContactDTO();
		
		contact.setId(1L);
		contact.setName("Ankur Kumar");
		contact.setPhone("9878677687");
		contact.setEmail("abc12@gmail.com");
		contact.setAddress("Bhopal");
		
		when(service.getAllContacts()).thenReturn(List.of(contact));
		
		var response = controller.getAllContact();
		
		assertEquals(200,response.getStatusCode().value());
		assertEquals(1, response.getBody().size());
		assertEquals("Ankur Kumar",response.getBody().get(0).getName());
	}
	
	@Test
	public void shouldGetContactById() {
		ContactDTO contact = new ContactDTO();
		
		contact.setId(1L);
		contact.setName("Ankur Kumar");
		contact.setPhone("9878677687");
		contact.setEmail("abc12@gmail.com");
		contact.setAddress("Bhopal");
		
		when(service.getContactById(1L)).thenReturn(contact);
		
		var response = controller.getContactById(1L);
		
		assertEquals(200,response.getStatusCode().value());
		assertEquals(1L,response.getBody().getId());
		assertEquals("Bhopal",response.getBody().getAddress());
	}
	
	@Test
	void shouldThrowExceptionWhenContactNotFound(){
		
		when(service.getContactById(99L)).thenThrow(new ContactNotFoundException("Contact not found with id: 99"));
		
		assertThrows(ContactNotFoundException.class,()-> controller.getContactById(99L));
	}
	
	@Test
	void shouldUpdateContact() {
		
		ContactDTO contact = new ContactDTO();
		
		contact.setId(1L);
		contact.setName("Ankur verma");
		contact.setPhone("9878677876");
		contact.setEmail("abcd12@gmail.com");
		contact.setAddress("Patna");
		
		when(service.updateContact(1L, contact)).thenReturn(contact);
		
		var response = controller.updateContact(1L, contact);
		
		assertEquals(200, response.getStatusCode().value());
		assertEquals("abcd12@gmail.com", response.getBody().getEmail());
		assertEquals("Patna",response.getBody().getAddress());
		
	}
	
	@Test
	void shouldDeleteContact() {
		
		ContactDTO contact = new ContactDTO();
		
		contact.setId(1L);
		
		when(service.getContactById(1L)).thenReturn(contact);
		
		var response = controller.deleteContact(1L);
		
		assertEquals(204,response.getStatusCode().value());
		
		verify(service).deleteContact(1L);
	}
	
	
	@Test
	void shouldThrowExceptionWhenDeletingNonExistingContact() {
		
		when(service.getContactById(99L)).thenThrow(new ContactNotFoundException("Contact not found with id: 99"));
		
		assertThrows(ContactNotFoundException.class,()-> controller.getContactById(99L));
		
		verify(service, never()).deleteContact(99L);
	}
	
	
	@Test
	void shouldThrowExceptionWhenUpdatingNonExistingContact() {
		
	    ContactDTO contact = new ContactDTO();

	    contact.setName("Ankur Verma");
	    contact.setPhone("9876789843");
	    contact.setEmail("ankurverma@gmail.com");
	    contact.setAddress("Noida");
	    
	    when(service.updateContact(99L, contact)).thenThrow(new ContactNotFoundException("Contact not found with id: 99"));
	    
	    assertThrows(ContactNotFoundException.class, ()->controller.updateContact(99L, contact));
	}
	
	@Test
	void shouldCreateContact() {
		
	    ContactDTO contact = new ContactDTO();
	    
	    contact.setName("Ankur Verma");
	    contact.setPhone("9876789843");
	    contact.setEmail("ankurverma@gmail.com");
	    contact.setAddress("Noida");
	    
	    ContactDTO savedContact = new ContactDTO();
	    
	    savedContact.setId(1L);
	    savedContact.setName("Ankur Verma");
	    savedContact.setPhone("9876789843");
	    savedContact.setEmail("ankurverma@gmail.com");
	    savedContact.setAddress("Noida");
	    
	    when(service.createContact(contact)).thenReturn(savedContact);
	    
	    var response = controller.createContact(contact);
	    
	    assertEquals(201,response.getStatusCode().value());
	    assertEquals("Noida", response.getBody().getAddress());
	    assertEquals(1L, response.getBody().getId());
	    
	    verify(service).createContact(contact);
	}
	
	@Test
	void shouldGetEmptyContactList() {
		
		when(service.getAllContacts()).thenReturn(List.of());
		
		var response = controller.getAllContact();
		
		assertEquals(200,response.getStatusCode().value());
		assertEquals(0,response.getBody().size());
		
		verify(service).getAllContacts();
	}
	
	@Test
	void shouldCreateContactWithAllFields() {
		
	    ContactDTO contact = new ContactDTO();

	    contact.setName("Ankur Verma");
	    contact.setPhone("9876789843");
	    contact.setEmail("ankurverma@gmail.com");
	    contact.setAddress("Noida");
	    
	    when(service.createContact(contact)).thenReturn(contact);
	    
	    var response = controller.createContact(contact);
	    
	    assertEquals(201, response.getStatusCode().value());
	    assertEquals("Ankur Verma", response.getBody().getName());
	    assertEquals("9876789843", response.getBody().getPhone());
	    assertEquals("ankurverma@gmail.com", response.getBody().getEmail());
	    assertEquals("Noida", response.getBody().getAddress());

	    verify(service).createContact(contact);
	}
	
	
	@Test
	void shouldUpdateContactSuccessfully() {
		
	    ContactDTO contact = new ContactDTO();
	    
	    contact.setId(1L);
	    contact.setName("Ankur kumar");
	    contact.setPhone("9876789786");
	    contact.setEmail("ankur@gmail.com");
	    contact.setAddress("Balia");
		
	    when(service.updateContact(1L, contact)).thenReturn(contact);
	    
	    var response = controller.updateContact(1L, contact);
	    
	    assertEquals(200, response.getStatusCode().value());
	    assertEquals(1L, response.getBody().getId());
	    assertEquals("Ankur kumar", response.getBody().getName());
	    assertEquals("9876789786", response.getBody().getPhone());
	    assertEquals("ankur@gmail.com", response.getBody().getEmail());
	    assertEquals("Balia", response.getBody().getAddress());

	    verify(service).updateContact(1L, contact);
	}
}
