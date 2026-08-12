package com.contactapp.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.contactapp.dto.ContactDTO;
import com.contactapp.service.ContactServiceImpl;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/contacts")
public class ContactController {

	private final ContactServiceImpl service;
	
	public ContactController(ContactServiceImpl service) {
		this.service = service;
	}
	
	@PostMapping
	public ResponseEntity<ContactDTO> createContact(@Valid @RequestBody ContactDTO dto){
		ContactDTO savedContact = service.createContact(dto);
		
		return new ResponseEntity<>(savedContact, HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<ContactDTO>> getAllContact(){
		List<ContactDTO> contacts = service.getAllContacts();
		
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
	
	@GetMapping("/search")
	public ResponseEntity<List<ContactDTO>> searchContactsByName(@RequestParam String name){
		List<ContactDTO> contacts=service.searchContactsByName(name);
		
		return ResponseEntity.ok(contacts);
	}
	
	@GetMapping("/search/address")
	public ResponseEntity<List<ContactDTO>> searchContactsByAddress(@RequestParam String address){
		
		List<ContactDTO> contacts = service.searchContactsByAddress(address);
		
		return ResponseEntity.ok(contacts);
	}
	
	@GetMapping("/search/email")
	public ResponseEntity<ContactDTO> searchContactsByEmail(@RequestParam String email){
		
		ContactDTO contact = service.searchContactsByEmail(email);
		
		return ResponseEntity.ok(contact);
	}
	
	@PatchMapping("/{id}/favorite")
	public ResponseEntity<ContactDTO> toggleFavorite(@PathVariable Long id) {

	    ContactDTO contact = service.toggleFavorite(id);

	    return ResponseEntity.ok(contact);
	}
	
	@GetMapping("/favorites")
	public ResponseEntity<List<ContactDTO>> getFavoriteContacts() {

	    List<ContactDTO> contacts = service.getFavoriteContacts();

	    return ResponseEntity.ok(contacts);
	}
}
