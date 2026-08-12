package com.contactapp.service;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import com.contactapp.dto.ContactDTO;
import com.contactapp.entity.Contact;
import com.contactapp.exception.ContactNotFoundException;
import com.contactapp.mapper.ContactMapper;
import com.contactapp.repository.ContactRepository;

public class ContactServiceImplTest {
	
	@Mock
	private ContactRepository repository;
	
	@Mock
	private ContactMapper mapper;
	
	@InjectMocks
	private ContactServiceImpl service;
	
	@BeforeEach
	void setup() {
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
	void shouldCreateContactSuccessfully() {
		
		ContactDTO dto = new ContactDTO();
		
		dto.setName("Ankur Verma");
		dto.setPhone("7869769778");
		dto.setEmail("ankur12@gmail.com");
		dto.setAddress("Bhopal");
		
		Contact contact = new Contact();
		
		Contact savedContact = new Contact();
		
		when(mapper.toEntity(dto)).thenReturn(contact);
		
		when(repository.save(contact)).thenReturn(savedContact);
		
		when(mapper.toDTO(savedContact)).thenReturn(dto);
		
		ContactDTO result = service.createContact(dto);
		
        assertEquals("Ankur Verma", result.getName());
        assertEquals("7869769778", result.getPhone());
        assertEquals("ankur12@gmail.com", result.getEmail());
        assertEquals("Bhopal", result.getAddress());
	}
	
	@Test
	void shouldGetAllContactsSuccessfully() {

	    Contact contact1 = new Contact();
	    contact1.setId(1L);
	    contact1.setName("Ankur Verma");

	    Contact contact2 = new Contact();
	    contact2.setId(2L);
	    contact2.setName("Rahul Kumar");

	    ContactDTO dto1 = new ContactDTO();
	    dto1.setId(1L);
	    dto1.setName("Ankur Verma");

	    ContactDTO dto2 = new ContactDTO();
	    dto2.setId(2L);
	    dto2.setName("Rahul Kumar");

	    when(repository.findAll())
	            .thenReturn(List.of(contact1, contact2));

	    when(mapper.toDTO(contact1))
	            .thenReturn(dto1);

	    when(mapper.toDTO(contact2))
	            .thenReturn(dto2);

	    List<ContactDTO> result = service.getAllContacts();

	    assertEquals(2, result.size());
	    assertEquals("Ankur Verma", result.get(0).getName());
	    assertEquals("Rahul Kumar", result.get(1).getName());
	}
	
	@Test
	void shouldGetContactByIdSuccessfully() {

	    Contact contact = new Contact();

	    contact.setId(1L);
	    contact.setName("Ankur Verma");
	    contact.setPhone("9876789843");
	    contact.setEmail("ankur@gmail.com");
	    contact.setAddress("Noida");

	    ContactDTO dto = new ContactDTO();

	    dto.setId(1L);
	    dto.setName("Ankur Verma");
	    dto.setPhone("9876789843");
	    dto.setEmail("ankur@gmail.com");
	    dto.setAddress("Noida");

	    when(repository.findById(1L))
	            .thenReturn(Optional.of(contact));

	    when(mapper.toDTO(contact))
	            .thenReturn(dto);

	    ContactDTO result = service.getContactById(1L);

	    assertEquals(1L, result.getId());
	    assertEquals("Ankur Verma", result.getName());
	    assertEquals("9876789843", result.getPhone());
	    assertEquals("ankur@gmail.com", result.getEmail());
	    assertEquals("Noida", result.getAddress());
	}
	
	@Test
	void shouldThrowExceptionWhenContactNotFound() {

	    when(repository.findById(99L))
	            .thenReturn(Optional.empty());

	    assertThrows(
	            ContactNotFoundException.class,
	            () -> service.getContactById(99L)
	    );
	}
	
	@Test
	void shouldUpdateContactSuccessfully() {

	    Contact existingContact = new Contact();

	    existingContact.setId(1L);
	    existingContact.setName("Old Name");
	    existingContact.setPhone("9876543210");
	    existingContact.setEmail("old@gmail.com");
	    existingContact.setAddress("Bhopal");

	    ContactDTO dto = new ContactDTO();

	    dto.setName("Ankur Verma");
	    dto.setPhone("9876789843");
	    dto.setEmail("ankur@gmail.com");
	    dto.setAddress("Noida");

	    Contact updatedContact = new Contact();

	    updatedContact.setId(1L);
	    updatedContact.setName("Ankur Verma");
	    updatedContact.setPhone("9876789843");
	    updatedContact.setEmail("ankur@gmail.com");
	    updatedContact.setAddress("Noida");

	    ContactDTO resultDTO = new ContactDTO();

	    resultDTO.setId(1L);
	    resultDTO.setName("Ankur Verma");
	    resultDTO.setPhone("9876789843");
	    resultDTO.setEmail("ankur@gmail.com");
	    resultDTO.setAddress("Noida");

	    when(repository.findById(1L))
	            .thenReturn(Optional.of(existingContact));

	    when(repository.save(existingContact))
	            .thenReturn(updatedContact);

	    when(mapper.toDTO(updatedContact))
	            .thenReturn(resultDTO);

	    ContactDTO result = service.updateContact(1L, dto);

	    assertEquals(1L, result.getId());
	    assertEquals("Ankur Verma", result.getName());
	    assertEquals("9876789843", result.getPhone());
	    assertEquals("ankur@gmail.com", result.getEmail());
	    assertEquals("Noida", result.getAddress());
	}
	
	@Test
	void shouldSearchContactsByNameSuccessfully() {

	    Contact contact1 = new Contact();
	    contact1.setId(1L);
	    contact1.setName("Ankur Verma");

	    Contact contact2 = new Contact();
	    contact2.setId(2L);
	    contact2.setName("Ankur Sharma");

	    ContactDTO dto1 = new ContactDTO();
	    dto1.setId(1L);
	    dto1.setName("Ankur Verma");

	    ContactDTO dto2 = new ContactDTO();
	    dto2.setId(2L);
	    dto2.setName("Ankur Sharma");

	    when(repository.findByNameContainingIgnoreCase("ankur"))
	            .thenReturn(List.of(contact1, contact2));

	    when(mapper.toDTO(contact1))
	            .thenReturn(dto1);

	    when(mapper.toDTO(contact2))
	            .thenReturn(dto2);

	    List<ContactDTO> result =
	            service.searchContactsByName("ankur");

	    assertEquals(2, result.size());
	    assertEquals("Ankur Verma", result.get(0).getName());
	    assertEquals("Ankur Sharma", result.get(1).getName());
	}
}
