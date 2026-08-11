package com.contactapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.contactapp.dto.ContactDTO;
import com.contactapp.entity.Contact;
import com.contactapp.exception.ContactNotFoundException;
import com.contactapp.mapper.ContactMapper;
import com.contactapp.repository.ContactRepository;

@Service
public class ContactService {

	private final ContactRepository contactRepository;
	private final ContactMapper mapper;
	
	public ContactService(ContactRepository contactRepository,ContactMapper mapper) {
		this.contactRepository=contactRepository;
		this.mapper=mapper;
	}
	
	public ContactDTO createContact(ContactDTO dto) {
		
		//DTO to Entity
		Contact contact = mapper.toEntity(dto);
		
		Contact savedContact= contactRepository.save(contact);
		
		return mapper.toDTO(savedContact);
	}
	
	public List<ContactDTO> getAllContact(){
		return contactRepository.findAll().stream().map(mapper::toDTO).toList();
	}
	
	public ContactDTO getContactById(Long id) {
		Contact contact = contactRepository.findById(id).orElseThrow(()-> new ContactNotFoundException("Contact not found with id: "+id));
		
	
		return mapper.toDTO(contact);
		
	}
	
	public ContactDTO updateContact(Long id, ContactDTO dto) {
		Contact existingContact = contactRepository.findById(id).orElseThrow(()-> new ContactNotFoundException("Contact not found with id: "+id));
		
		existingContact.setName(dto.getName());
		existingContact.setPhone(dto.getPhone());
		existingContact.setEmail(dto.getEmail());
		existingContact.setAddress(dto.getAddress());
		
		Contact update= contactRepository.save(existingContact);
		
		return mapper.toDTO(update);

		
	}
	
	public void deleteContact(Long id) {
		
		if(!contactRepository.existsById(id)) {
			throw new ContactNotFoundException("Contact not found with id: "+id);
		}
		contactRepository.deleteById(id);
	}
}
