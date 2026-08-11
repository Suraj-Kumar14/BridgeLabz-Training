package com.contactapp.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.contactapp.dto.ContactDTO;
import com.contactapp.service.ContactService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/contacts")
public class ContactController {

	private final ContactService service;
	
	public ContactController(ContactService service) {
		this.service = service;
	}
	
	@PostMapping
	public ResponseEntity<ContactDTO> createContact(@Valid @RequestBody ContactDTO dto){
		ContactDTO savedContact = service.createContact(dto);
		
		return new ResponseEntity<>(savedContact, HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<ContactDTO>> getAllContact(){
		List<ContactDTO> contacts = service.getAllContact();
		
		return ResponseEntity.ok(contacts);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ContactDTO> getContactById(@PathVariable Long id){
		
		ContactDTO contact = service.getContactById(id);
		
		return ResponseEntity.ok(contact);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ContactDTO> updateContact( @PathVariable Long id, @Valid @RequestBody ContactDTO dto){
		
		ContactDTO updateContact = service.updateContact(id, dto);
				
		return ResponseEntity.ok(updateContact);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteContact(@PathVariable Long id){
		
		service.deleteContact(id);
		
		return ResponseEntity.noContent().build();
	}
}
